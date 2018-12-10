create database	electronic;
use electronic;

create table common_information_for_notebook(
id int primary key AUTO_INCREMENT,
time_enter varchar(255),
type varchar(255),
transformer boolean);

create table processor_for_notebook(
id int primary key AUTO_INCREMENT,
platform varchar(255),
processor_name varchar(255),
model_processor varchar(255),
core int,
frequency int,
turbo_frequency int,
power_usage int);


create table construction_for_notebook(
id int primary key AUTO_INCREMENT,
material_body varchar(255),
color_body varchar(255),
material_cap varchar(255),
color_car varchar(255),
backlight boolean,
impact_resistance boolean);


create table screen_for_notebook (
id int primary key AUTO_INCREMENT,
diagonal double,
resolution varchar(255),
technologi varchar(255),
surface varchar(255),
sensonal boolean,
d3_screen boolean,
pen_input boolean,
impact_resistance boolean);

create table weight_and_size_for_notebook (
id int primary key AUTO_INCREMENT,
width double,
depth double,
thickness double,
weight double);


create table ram_for_notebook (
id int primary key AUTO_INCREMENT,
type varchar(255),
volume int);

create table data_for_notebook (
id int primary key AUTO_INCREMENT,
configuration varchar(255),
type varchar(255),
volume int,
optical boolean,
memory_card boolean);


create table graphics_for_notebook (
id int primary key AUTO_INCREMENT,
adapter varchar(255),
type varchar(255),
volume int);


create table camera_sound_for_notebook (
id int primary key AUTO_INCREMENT,
camera boolean,
microphone boolean,
dinamics varchar(255),
pixel int);


create table keyboard_and_touchpad_for_notebook (
id int primary key AUTO_INCREMENT,
numpad boolean,
backlight boolean,
kirilitca boolean,
touchpad varchar(255),
multimedia_pannel boolean);

create table founctions_for_notebook (
id int primary key AUTO_INCREMENT,
scaner boolean);


create table interface_for_notebook (
id int primary key AUTO_INCREMENT,
nfc boolean,
bluetooth varchar(255),
LAN boolean,
wifi varchar(255),
mobile boolean,
usb_port int,
usb_2 int,
usb_3 int,
usb_3_1_a int,
usb_3_1_c int,
vga boolean,
hdmi boolean,
display_port boolean,
thounderbolt boolean,
jack boolean);


create table battery_for_notebook(
id int primary key AUTO_INCREMENT,
time varchar(255),
cell int,
energy int);


create table complectation_for_notebook (
id int primary key AUTO_INCREMENT,
batary_2 boolean,
mouse boolean,
bag_case boolean,
complect varchar(255));


create table notebook
(id int primary key AUTO_INCREMENT,
mark varchar(255),
name varchar(255),
id_common_information_for_notebook int,
id_processor_for_notebook int,
id_construction_for_notebook int,
id_weight_and_size_for_notebook int,
id_screen_for_notebook int,
id_ram_for_notebook int,
id_data_for_notebook int,
id_graphics_for_notebook int,
id_camera_sound_for_notebook int,
id_keyboard_and_touchpad_for_notebook int,
id_founctions_for_notebook int,
id_interface_for_notebook int,
id_battery_for_notebook int,
id_complectation_for_notebook int);


alter table notebook
add constraint id_complectation_for_notebook foreign key (id_complectation_for_notebook)
references complectation_for_notebook(id);


alter table notebook
add constraint id_interface_for_notebook foreign key (id_interface_for_notebook)
references interface_for_notebook(id);


alter table notebook
add constraint id_founctions_for_notebook foreign key (id_founctions_for_notebook)
references founctions_for_notebook(id);


alter table notebook
add constraint id_keyboard_and_touchpad_for_notebook foreign key (id_keyboard_and_touchpad_for_notebook)
references keyboard_and_touchpad_for_notebook(id);


alter table notebook
add constraint id_camera_sound_for_notebook foreign key (id_camera_sound_for_notebook)
references camera_sound_for_notebook(id);


alter table notebook
add constraint id_graphics_for_notebook foreign key (id_graphics_for_notebook)
references graphics_for_notebook(id);


alter table notebook
add constraint id_data_for_notebook foreign key (id_data_for_notebook)
references data_for_notebook(id);


alter table notebook
add constraint id_ram_for_notebook foreign key (id_ram_for_notebook)
references ram_for_notebook(id);

alter table notebook
add constraint id_weight_and_size_for_notebook foreign key (id_weight_and_size_for_notebook)
references weight_and_size_for_notebook(id);

alter table notebook
add constraint id_screen_for_notebook foreign key (id_screen_for_notebook)
references screen_for_notebook(id);

alter table notebook
add constraint id_common_information_for_notebook foreign key (id_common_information_for_notebook)
references common_information_for_notebook(id);

alter table notebook
add constraint id_proceessor_for_notebook foreign key (id_processor_for_notebook)
references processor_for_notebook(id);

alter table notebook
add constraint id_construction_for_notebook foreign key (id_construction_for_notebook)
references construction_for_notebook(id);


create table points
(id_point int primary key AUTO_INCREMENT,
 name_of_point varchar(255));

create table route
(id_route int primary key AUTO_INCREMENT,
 name_of_route varchar(255),
 start_point_of_route int,
 end_point_of_route int);

create table transport
(id_transport int primary key auto_increment,
 transport_name varchar(255),
 speed int,
 coefficient double,
 max_weight int,
  check (coefficient > 1 and speed > 40 and max_weight > 0));

create table maps
(id_maps int primary key AUTO_INCREMENT,
 start_point_id int,
 end_point_id int,
 route int,
 distance double,
 id_transport_in_maps int,
 cost_for_hour double);

create table user
(id int primary key AUTO_INCREMENT,
 login varchar(255),
 password varchar(255),
 role varchar(255),
  unique(login));


alter table route
  add constraint starts_point_id foreign key (start_point_of_route)
references points(id_point);

alter table route
  add constraint ends_point_id foreign key (end_point_of_route)
references points(id_point);

alter table maps
  add constraint start_point_id foreign key (start_point_id)
references points(id_point);

alter table maps
  add constraint route_id foreign key (route)
references route(id_route);

alter table maps
  add constraint end_point_id foreign key (end_point_id)
references points(id_point);

alter table maps
  add constraint transport_maps foreign key (id_transport_in_maps)
references transport(id_transport);

alter table maps
  add constraint unique_path unique(start_point_id, end_point_id, route);

