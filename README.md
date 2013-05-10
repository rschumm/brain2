brain 2.0
======

Einführungsaufgabe für Joël Niederhauser



Idee
----

Brain ist ein Tool, das Deploy-Commands für unser Rechenzentrum generiert. 
Es heisst deshalb Brain, weil es weiss, welche Version von welcher Applikation auf welchem Sever auf welchem Stage läuft. 



Architektur
-----------

Das Gui ist bestehend und basiert auf Bootstrap von Twitter. Die Logik sind einfache JS mit jQuery. 

Neu soll eine Persistenz-Schicht aufgebaut werden: 

- Jetty Server mit JEE6, direkt im eclipse gestartet
- H2 Datenbank mit JPA
- RESTful WS mit JAX-RS
- Zugriff über AJAX mit jQuery


Aufgaben und Ziel
-----------------


Die Aufgaben werden im github-wiki bzw. Issues verwaltet.   
Mit dieser Einführungsaufgabe sollen folgende Dinge geübt werden: 
- Umgang mit SQL und Datenmodellen
- Umgamg mit JPA
- Erste Erfahrungen mit RESTful und AJAX
- Umgang mit git



URLs
----

Initial Aufgabenstellung, auf JBoss EAP 6 deployd:  

http://localhost:8080/brain2/brain2

Zum Deploy: goal jboss-as:deploy  ...undeploy, ...redeploy



