CREATE TABLE `Wifi_Detail` (
                               `X_SWIFI_MGR_NO`	varchar(50)	NOT NULL PRIMARY KEY,
                               `X_SWIFI_WRDOFC`	varchar(100)	NULL,
                               `X_SWIFI_MAIN_NM`	varchar(100)	NULL,
                               `X_SWIFI_ADRES1`	varchar(100)	NULL,
                               `X_SWIFI_ADRES2`	varchar(100)	NULL,
                               `X_SWIFI_INSTL_FLOOR`	varchar(50)	NULL,
                               `X_SWIFI_INSTL_TY`	varchar(50)	NULL,
                               `X_SWIFI_INSTL_MBY`	varchar(50)	NULL,
                               `X_SWIFI_SVC_SE`	varchar(100)	NULL,
                               `X_SWIFI_CMCWR`	varchar(100)	NULL,
                               `X_SWIFI_CNSTC_YEAR`	varchar(50)	NULL,
                               `X_SWIFI_INOUT_DOOR`	varchar(50)	NULL,
                               `X_SWIFI_REMARS3`	varchar(100)	NULL,
                               `LAT`	double	NULL,
                               `LNT`	double	NULL,
                               `WORK_DTTM`	varchar(50)	NULL
) DEFAULT CHARACTER SET UTF8;


CREATE TABLE `History` (
                           `ID`	integer	NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                           `LAT`	double	NULL,
                           `LNT`	double	NULL,
                           `DATE`	varchar(50)	NULL
) DEFAULT CHARACTER SET UTF8;


CREATE TABLE `Bookmark_Group` (
                                  `BOOKMARK_GROUP_ID`	integer	NULL PRIMARY KEY AUTO_INCREMENT,
                                  `SEQ_NUM`	integer	NULL,
                                  `REGIST_DATE`	varchar(50)	NULL,
                                  `MODIFY_DATE`	varchar(100)	NULL,
                                  `BOOKMARK_NAME`	varchar(100)	NOT NULL
) DEFAULT CHARACTER SET UTF8;


CREATE TABLE `Bookmark_Detail` (
                                   `ID`	integer	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                   `BOOKMARK_GROUP_ID`	integer	NULL,
                                   `WIFI_NAME`	varchar(50)	NULL,
                                   `REGIST_DATE`	varchar(50)	NULL,
                                   `MNG_NO` varchar(50) NULL
) DEFAULT CHARACTER SET UTF8;


ALTER TABLE `Bookmark_Detail` ADD CONSTRAINT `FK_Bookmark_Group_TO_Bookmark_Detail_1` FOREIGN KEY (
                                                                                                   `BOOKMARK_GROUP_ID`
    )
    REFERENCES `Bookmark_Group` (
                                 `BOOKMARK_GROUP_ID`
        )
    ON DELETE CASCADE ON UPDATE CASCADE ;