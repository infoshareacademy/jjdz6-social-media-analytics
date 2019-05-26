FROM jboss/wildfly

MAINTAINER "social-media-analytics"

RUN wildfly/bin/add-user.sh admin admin --silent

ADD target/social-media-analytics.war wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
