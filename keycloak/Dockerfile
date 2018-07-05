FROM jboss/keycloak
ADD import-realm.json /opt/jboss/keycloak/

CMD ["-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Dkeycloak.import=/opt/jboss/keycloak/import-realm.json"]
