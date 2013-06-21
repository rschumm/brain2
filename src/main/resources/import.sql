
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,EXTENSION) VALUES (1,'oms-ear','com.axa.ch.oms','oms-ear','ear');
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,EXTENSION) VALUES (2,'csi-ear','com.axa.ch.csi','csi-ear','ear');
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,EXTENSION) VALUES (3,'schumm','ch.schumm.sonne','sonne','war');


INSERT INTO "BRAIN2"."PUBLIC"."SERVER" (ID,URL,NUMBER,DESCRIPTION) VALUES (1,'lxfapp26.undefined.firma.intranet',0,'server 1 (oms)');
INSERT INTO "BRAIN2"."PUBLIC"."SERVER" (ID,URL,NUMBER,DESCRIPTION) VALUES (2,'lxfapp27.undefined.firma.intranet',1,'server 2 (csi)');



INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (1,'Development','dev');
INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (2,'Acceptance','acc');
INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (3,'Production','prod');




INSERT INTO "BRAIN2"."PUBLIC"."VERSION" (ID,VERSIONSNR) VALUES (0,'0.0.42');