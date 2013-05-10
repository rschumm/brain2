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





# Aufgabe 1 - git, Projekt aufsetzen und die Sache mit maven


Bei der ersten Aufgabe geht es darum, das Projekt in Eclipse aufzusetzen und zum ersten Mal zu lernen, wie man mit dem Versionsverwaltugnsystem (SCM) git umgeht.  
Ein Projketgerüst existiert schon - hier auf github. Folgende Dinge sind zu tun: 

1. Erstelle einen neuen, leeren Workspace  
2. Installiere über die Update-Site von Biersack die git-Tools herunter
3. Clone dieses Projekt aus github. 
4. Lass Dir die Sache mit maven von mir erklären
5. Lass Dir die Sache mit SCM, CVS und git von mir erklären


# Aufgabe 2 - ER Datenmodell

Bei dieser Aufgabe geht es darum, das Datenmodell für unser Brain zu überlegen. 

Grundsätzlich gibt es folgende Dinge: 

Die drei Stages DEV, ACC und PROD. In jeder Stage gibt es die gleichen Server, welche einen Namen, eine URL und eine Nummer haben.  
Dann gibt es Deploy-Artefakte, die auf bestimmten Servern installiert werden. Dabei muss sich Brain merken, auf welchem Stage welche Version von welchem Artefakt installiert ist.  

Erstelle dazu sein Datenmodell er auf Papier. 


# Aufgabe 3 - H2 Datenbank

Lese die Dokumentation zur H2 Datenbank, und überlege, wie Du im Workspace eine H2 Datenbank im embeded mode mit File-Persistenz starten kannst. [H2 Doku](http://www.h2database.com/html/features.html#connection_modes)




