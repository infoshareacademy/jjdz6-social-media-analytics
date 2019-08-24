<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>#Trend Map</title>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }

        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 1080px;
            margin: 0;
            padding: 0;
            background-color: #3aabef;
        }


        .form {
            margin: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            color: white;
            font-size: 25px;
            font-family: sans-serif;
            text-align: center;
        }


        }


        /* The popup bubble styling. */
        .popup-bubble {
            /* Position the bubble centred-above its parent. */
            position: absolute;
            top: 0;
            left: 0;
            transform: translate(-50%, -100%);
            /* Style the bubble. */
            background-color: white;
            padding: 5px;
            border-radius: 5px;
            font-family: sans-serif;
            overflow-y: auto;
            max-height: 60px;
            box-shadow: 0px 2px 10px 1px rgba(0, 0, 0, 0.5);
        }

        /* The parent of the bubble. A zero-height div at the top of the tip. */
        .popup-bubble-anchor {
            /* Position the div a fixed distance above the tip. */
            position: absolute;
            width: 100%;
            bottom: /* TIP_HEIGHT= */ 8px;
            left: 0;
        }

        /* This element draws the tip. */
        .popup-bubble-anchor::after {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            /* Center the tip horizontally. */
            transform: translate(-50%, 0);
            /* The tip is a https://css-tricks.com/snippets/css/css-triangle/ */
            width: 0;
            height: 0;
            /* The tip is 8px high, and 12px wide. */
            border-left: 6px solid transparent;
            border-right: 6px solid transparent;
            border-top: /* TIP_HEIGHT= */ 8px solid white;
        }

        /* JavaScript will position this div at the bottom of the popup tip. */
        .popup-container {
            cursor: auto;
            height: 0;
            position: absolute;
            /* The max width of the info window. */
            width: 200px;
        }

        .main-menu>a {
            display: block;
            margin: 0 auto;
            text-align: center;
            /*position: absolute;*/
            /*right: 250px;*/
            color: white;
            text-decoration: none;
            text-underline: none;

        }


        #content > a {
            font-size: 25px;
            text-decoration: none;
            color: #e74c3c;
            background-color: white;
            border: 4px solid black;
            border-radius: 10px;
            padding: 15px 15px;
        }

        .button {
            text-align: center;
            padding: 20px 20px;
            font-size: 20px;
            color: black;
            border-radius: 20px;

        }

        .button:hover {
            background-color: #e74c3c;
            color: white;
        }

        .place {
            font-size: 25px;
            border-radius: 20px;
        }

        .image {
           text-align: center;

        }

        .image>img {
            border: 6px solid deepskyblue;
        }
*#map {
    margin:  0 auto;
    height: 800px;
    width: 800px;
}
    </style>
</head>
<body>
<div class="main-menu"><a href="/main">Menu</a></div>
<div class="form">
    <form method="post" action="map-trends">
        Place: <input class="place" type="text" name="place"/><br/><br/>
        <input class="button" type="submit" name="Submit" value="Submit"/><br/><br/>
    </form>
</div>
<div id="content">
    <a href="${trends.URL}">${trends.name}</a>
</div>
<div id="map"></div>
<script>

    var map, popup, Popup;
    var lat = parseFloat(${coord.lat});
    var lnn = parseFloat(${coord.ln});

    /** Initializes the map and the custom popup. */
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: lat, lng: lnn},
            zoom: 5,
        });

        Popup = createPopupClass();
        popup = new Popup(
            new google.maps.LatLng(lat, lnn),
            document.getElementById('content'));
        popup.setMap(map);
    }

    /**
     * Returns the Popup class.
     *
     * Unfortunately, the Popup class can only be defined after
     * google.maps.OverlayView is defined, when the Maps API is loaded.
     * This function should be called by initMap.
     */
    function createPopupClass() {
        /**
         * A customized popup on the map.
         * @param {!google.maps.LatLng} position
         * @param {!Element} content The bubble div.
         * @constructor
         * @extends {google.maps.OverlayView}
         */
        function Popup(position, content) {
            this.position = position;

            content.classList.add('popup-bubble');

            // This zero-height div is positioned at the bottom of the bubble.
            var bubbleAnchor = document.createElement('div');
            bubbleAnchor.classList.add('popup-bubble-anchor');
            bubbleAnchor.appendChild(content);

            // This zero-height div is positioned at the bottom of the tip.
            this.containerDiv = document.createElement('div');
            this.containerDiv.classList.add('popup-container');
            this.containerDiv.appendChild(bubbleAnchor);

            // Optionally stop clicks, etc., from bubbling up to the map.
            google.maps.OverlayView.preventMapHitsAndGesturesFrom(this.containerDiv);
        }

        // ES5 magic to extend google.maps.OverlayView.
        Popup.prototype = Object.create(google.maps.OverlayView.prototype);

        /** Called when the popup is added to the map. */
        Popup.prototype.onAdd = function () {
            this.getPanes().floatPane.appendChild(this.containerDiv);
        };

        /** Called when the popup is removed from the map. */
        Popup.prototype.onRemove = function () {
            if (this.containerDiv.parentElement) {
                this.containerDiv.parentElement.removeChild(this.containerDiv);
            }
        };

        /** Called each frame when the popup needs to draw itself. */
        Popup.prototype.draw = function () {
            var divPosition = this.getProjection().fromLatLngToDivPixel(this.position);

            // Hide the popup when it is far out of view.
            var display =
                Math.abs(divPosition.x) < 4000 && Math.abs(divPosition.y) < 4000 ?
                    'block' :
                    'none';

            if (display === 'block') {
                this.containerDiv.style.left = divPosition.x + 'px';
                this.containerDiv.style.top = divPosition.y + 'px';
            }
            if (this.containerDiv.style.display !== display) {
                this.containerDiv.style.display = display;
            }
        };

        return Popup;
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB7PCQggzOtF1cQbGw_Gfho06NLBApfvBA&callback=initMap">
</script>
</body>
</html>