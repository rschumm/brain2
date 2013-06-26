
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,BUNDLEID,EXTENSION) VALUES (1,'oms-ear','com.axa.ch.oms','oms-ear','oms-ear','ear');
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,BUNDLEID,EXTENSION) VALUES (2,'csi-ear','com.axa.ch.csi','csi-ear','csi-ear','ear');
INSERT INTO "BRAIN2"."PUBLIC"."DEPLOYARTEFAKT" (ID,NAME,GROUPID,ARTEFAKTID,BUNDLEID,EXTENSION) VALUES (3,'schumm','ch.schumm.sonne','sonne','sonne-bundle','war');


INSERT INTO "BRAIN2"."PUBLIC"."SERVER" (ID,URL,NUMBER,DESCRIPTION) VALUES (1,'lxfapp26',0,'server 1 (oms)');
INSERT INTO "BRAIN2"."PUBLIC"."SERVER" (ID,URL,NUMBER,DESCRIPTION) VALUES (2,'lxfapp27',1,'server 2 (csi)');



INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (1,'Development','dev');
INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (2,'Acceptance','acc');
INSERT INTO "BRAIN2"."PUBLIC"."STAGE" (ID,NAME,KURZNAME) VALUES (3,'Production','prod');


--INSERT INTO "BRAIN2"."PUBLIC"."VERSION" (ID,VERSIONSNR) VALUES (1,'1.0.42');
--INSERT INTO "BRAIN2"."PUBLIC"."INSTALLATION" (ID,SERVER_IDFS,DEPLOYARTEFAKT_IDFS,VERSION_IDFS,STAGE_IDFS) VALUES (1,1,3,1,1)