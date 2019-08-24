<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        /* Always set the map height explicitly to define the size of the div
                * element that contains the map. */


        /* Optional: Makes the sample page fill the window. */
        html, body {
            margin: 0;
            padding: 0;
            background-color: #3aabef;
        }

        #map {
            height: 100%;

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

        .main-menu > a {
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

        #contentWarsaw {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentBerlin {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentParis {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentItaly {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentMoscow {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentSweden {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentUkraine {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentNorway {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }

        #contentEngland {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }
        #contentChina {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }
        #contentNewYork {
            text-align: center;
            font-size: 25px;
            background-color: lightblue;
            color: white;
            padding: 10px 10px;
        }
    </style>
</head>
<body>

<div id="map"></div>
<div id="contentWarsaw">
    ${trendsWarsaw.name}
</div>
<div id="contentBerlin">
    ${trendsBerlin.name}
</div>
<div id="contentParis">
    ${trendsParis.name}
</div>

<div id="contentItaly">
    ${trendsItaly.name}
</div>

<div id="contentMoscow">
    ${trendsMoscow.name}
</div>
<div id="contentSweden">
    ${trendsSweden.name}
</div>
<div id="contentUkraine">
    ${trendsUkraine.name}
</div>
<div id="contentNorway">
    ${trendsNorway.name}
</div>

<div id="contentEngland">
    ${trendsEngland.name}
</div>
<div id="contentChina">
    ${trendsChina.name}
</div>
<div id="contentNewYork">
    ${trendsNewYork.name}
</div>


<script>

    function initMap() {
        var myLatLng = {lat: 52.363, lng: 21.044};

        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 4,
            center: myLatLng
        });

        Popup = createPopupClass();
        popup = new Popup(
            new google.maps.LatLng(52.866, 21.044),
            document.getElementById('contentWarsaw'));
        popup.setMap(map);

        Popup2 = createPopupClass();
        popup2 = new Popup2(
            new google.maps.LatLng(51.133481, 10.018343),
            document.getElementById('contentBerlin'));
        popup2.setMap(map);

        Popup3 = createPopupClass();
        popup3 = new Popup3(
            new google.maps.LatLng(48.8566, 2.3522),
            document.getElementById('contentParis'));
        popup3.setMap(map);

        Popup4 = createPopupClass();
        popup4 = new Popup4(
            new google.maps.LatLng(41.8947, 12.4839),
            document.getElementById('contentItaly'));
        popup4.setMap(map);

        Popup5 = createPopupClass();
        popup5 = new Popup5(
            new google.maps.LatLng(55.7522, 37.6156),
            document.getElementById('contentMoscow'));
        popup5.setMap(map);

        Popup6 = createPopupClass();
        popup6 = new Popup6(
            new google.maps.LatLng(59.3326, 18.0649),
            document.getElementById('contentSweden'));
        popup6.setMap(map);

        Popup7 = createPopupClass();
        popup7 = new Popup7(
            new google.maps.LatLng(50.4547, 30.5238),
            document.getElementById('contentUkraine'));
        popup7.setMap(map);


        Popup8 = createPopupClass();
        popup8 = new Popup8(
            new google.maps.LatLng(59.9139, 10.7522),
            document.getElementById('contentNorway'));
        popup8.setMap(map);

        Popup9 = createPopupClass();
        popup9 = new Popup9(
            new google.maps.LatLng(51.5085, -2.1244),
            document.getElementById('contentEngland'));
        popup9.setMap(map);

        Popup10 = createPopupClass();
        popup10 = new Popup10(
            new google.maps.LatLng(39.9288,	116.3890 ),
            document.getElementById('contentChina'));
        popup10.setMap(map);

        Popup11 = createPopupClass();
        popup11 = new Popup11(
            new google.maps.LatLng(40.730610, -73.935242),
            document.getElementById('contentNewYork'));
        popup11.setMap(map);
    }


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