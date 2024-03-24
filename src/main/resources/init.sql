--地图表
create table sds_ol_map(
                             mapid    varchar(50) not null PRIMARY KEY,
                             mapname varchar(50) not null,
                             view    jsonb not null,            -- 地图的视图配置
                             controls    varchar(50) [],        -- 控件
                             pixelRatio     integer,            --像素比率，整型
                             interactions varchar(50) [],       --交互方式
                             layers    varchar(50) [],          -- 图层名称
                             logo    boolean,                   -- 是否显示logo
                             overlays    varchar(50) [],        -- 覆盖层
                             description varchar(50)
);

--视图 描述中心点，缩放级别，旋转角度，投影方式等属性
create table sds_ol_view(
                              viewid    varchar(50) not null PRIMARY KEY,   --
                              viewname    varchar(50) not null,
                              center    double precision ARRAY[2],
                              extent  double precision	ARRAY[4],
                              maxresolution    varchar(50),
                              minresolution    varchar(50),
                              maxzoom    int,
                              minzoom    int,
                              zoom    int,      --缩放
                              projection    varchar(50),
                              resolution    varchar(50),    --分辨率
                              resolutions    varchar(50) ARRAY,
                              rotation    NUMERIC(7,4),     -- 旋转角度
                              description varchar(50)
);

--样式类型枚举值
CREATE TYPE sds_ol_vectorstyletype AS ENUM('entity', 'function');


--矢量图层表
create table sds_ol_layer_vector(
                                      layerid    varchar(50) not null PRIMARY KEY,
                                      layername    varchar(50) not null,
                                      opacity  real,
                                      visible    boolean,
                                      extent decimal ARRAY[4],
                                      zIndex     integer,
                                      minResolution    decimal,
                                      maxResolution    decimal,

                                      source   varchar(50) not null,
                                      styletype    sds_ol_vectorstyletype not null,
                                      stylevalue    varchar(50) not null,

                                      description varchar(50)
);


--切片图层表
create table sds_ol_layer_tile(
                                    layerid    varchar(50) not null PRIMARY KEY,
                                    layername    varchar(50) not null,
                                    opacity  real,
                                    visible    boolean,
                                    extent decimal ARRAY[4],
                                    minResolution  decimal,
                                    maxResolution  decimal,
                                    source     varchar(50) ARRAY[2] not null,
                                    description varchar(50)
);




--图层表
create table sds_ol_layer(
                               layerId    varchar(50) not null PRIMARY KEY,
                               layerName    varchar(50) not null,
                               aliasName   varchar(50),
                               opacity  numeric(1,5),
                               source   varchar(50),
                               visible    boolean,
                               extent numeric ARRAY[4],
                               zIndex   integer,
                               minResolution    numeric,
                               maxResolution    numeric,
                               type   varchar(50),
                               options  jsonb,
                               description varchar(50)
);

ALTER TABLE sds_ol_layer ALTER COLUMN opacity type numeric(1,5);

--取样线表
create table sds_sample_line(
                                lineId varchar(50) not null PRIMARY KEY,
                                layerId varchar(50) not null,
                                lineName  varchar(50) not null,
                                lineSource GEOMETRY(LineString, 4326) not null,
                                description varchar(50) not null
);

--矿山切片表
create table  vertical_mine_section(
                               sectionId varchar(50) not null primary key,
                               sectionName varchar(50) not null,
                               sectionSourceId varchar(50) not null,
                               sampleLineId varchar(50) not null,
                               description varchar(50)
);

create table vertical_min_section_source(
                               sourceId varchar(50) not null primary key,
                               sectionId varchar(50) not null,
                               -- lineSource GEOMETRY(LineString, 4326)[] not null,
                               -- source varchar(50) not null, 存储到云服务器，依据取样线中点坐标范围性缓存，
                               rockId varchar(50) not null,
                               description varchar(50)
);

create table rock_byte_data(
                               rockId varchar(50) not null primary key,
                               rockName varchar(50) not null,
                               legend varchar(50) not null,
                               description varchar(50)
);





--ArcGIS切片服务
create table sds_ol_source_tilearcgisrest(
                                               sourceid    varchar(50) not null PRIMARY KEY,
                                               sourcename    varchar(50) not null,
                                               crossOrigin    varchar(50),
                                               projection    varchar(20),
                                               url    varchar(100) not null,
                                               wrapX    boolean,
                                               description varchar(50)
);

--SuperMap切片服务
create table sds_ol_source_tilesupermaprest(
                                                 sourceid    varchar(50) not null PRIMARY KEY,
                                                 sourcename    varchar(50) not null,
                                                 url    varchar(100) not null,
                                                 wrapX    boolean,
                                                 opaque    boolean,
                                                 description varchar(50)
);

--矢量数据
create table sds_ol_source_vector(
                                       sourceid    varchar(50) not null PRIMARY KEY,
                                       sourcename    varchar(50) not null,
                                       logo boolean,
                                       url    varchar(50),
                                       useSpatialIndex boolean,
                                       wrapX    boolean,
                                       description varchar(50)
);

--wmts服务，涉及到切片，切片的处理逻辑由ol完成
create table sds_ol_source_wmts(
                                     sourceid    varchar(50) not null PRIMARY KEY,
                                     sourcename    varchar(50) not null,
                                     url    varchar(50) not null,
                                     layer    varchar(50) not null,
                                     style    varchar(50) not null,
                                     format    varchar(50) not null,
                                     matrixSet    varchar(50) not null,
                                     description varchar(50)
);

--地图数据源
create table sds_ol_source(
                                sourceId    varchar(50) not null PRIMARY KEY,
                                sourceName    varchar(50) not null,
                                type    varchar(50) not null,
                                projection    varchar(50) not null,             --投影方式
                                options   jsonb,                                -- ol要求的一些其他属性
                                description varchar(50)
);
--经纬度投影（例如 EPSG:4326）：地图数据使用经度和纬度来表示位置，是一种最常见的地理坐标系统。

--Web Mercator 投影（例如 EPSG:3857）：一种用于 Web 地图的常用投影方式，特别适用于在 Web 上展示地图数据。


--样式表
create table sds_ol_style_style(
                                     styleid    varchar(50) not null,
                                     stylename    varchar(50) not null,
                                     fill    varchar(50),
                                     image    varchar(50),
                                     stroke    varchar(50),
                                     text    varchar(50),
                                     description varchar(50)
);

--填充面样式
create table sds_ol_style_fill(
                                    styleid    varchar(50) not null,
                                    stylename    varchar(50) not null,
                                    color    varchar(50) not null,
                                    description varchar(50)
);

--边框样式
create table sds_ol_style_stroke(
                                      styleid    varchar(50) not null,
                                      stylename    varchar(50) not null,
                                      color    varchar(50) not null,
                                      width    integer,
                                      lineCap    varchar(50),
                                      lineJoin    varchar(50),
                                      description varchar(50)
);

--图标样式
create table sds_ol_style_icon(
                                    styleid    varchar(50) not null,
                                    stylename    varchar(50) not null,
                                    anchor    real ARRAY,
                                    anchorOrigin    varchar(20),
                                    anchorXUnits    varchar(20),
                                    anchorYUnits    varchar(20),
                                    color    varchar(20),
                                    crossOrigin    real,
                                    description varchar(50)
);
