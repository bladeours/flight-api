# Flight REST API
Simple REST API that returns information about airports.

## Table of Contents
* [General info](#general-info)
* [Authorization](#authorization)
* [Technologies Used](#technologies-used)
* [Setup](#setup)
* [Endpoints](#endpoints)


## General Info
This REST API is a part of Flight Search Engine project. \
I've created this project to get information about flights, I'm using it in
[flight search engine MVC](https://github.com/bladeours/flight-search-engine) project.
It uses MySQL database to store data.


## Technologies Used
* Spring
* Java 17
* MySQL

## Authorization
// TODO

## Setup

### Install on local machine

#### Install MySQL
check official [MySQL Documentation](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)

#### Create database & import data
```
Type: mysql -u username -p any_database_name < database/create_whole_database.sql
script create database so you don't have worry about database name
If you've assigned a password, type it now and press Enter.
```

### Run with docker

#### Docker-compose

* `git clone https://github.com/bladeours/flight-api.git`
* `docker-compose -d`

if you want to change ports or credentials then edit `.env` file. \
Unfortunately container with api needs to restart couple times because it needs wait for
mysql container at this moment. I'll improve this in the future. 

#### Run API
**this app requires Java 17** \
`java -jar flightApi.jar`

## endpoints

### Airport
#### Airport by code
GET: `/airport/{code}` \
Return:
* DepartureFlights
* ArrivalFlights
* code
* city
* country

Here is sample output:
\
`curl localhost:8082/airport/WAW`
```
{
   "code":"ZSS",
   "city":"Sassandra",
   "country":"Ivory Coast",
   "departureFlights":[
      {
         "id":121,
         "departureAirport":{
            "code":"ZSS",
            "city":"Sassandra",
            "country":"Ivory Coast"
         },
         "arrivalAirport":{
            "code":"SBY",
            "city":"Salisbury, MD",
            "country":"USA"
         },
         "departureDate":1668200839000,
         "flightTime":"08:56:57",
         "allSeats":156,
         "freeSeats":104,
         "price":1540.164,
         "company":{
            "id":13,
            "name":"SkyWest Airlines"
         },
         "distance_km":7874
      }
   ],
   "arrivalFlights":[
      {
         "id":72,
         "departureAirport":{
            "code":"SBY",
            "city":"Salisbury, MD",
            "country":"USA"
         },
         "arrivalAirport":{
            "code":"ZSS",
            "city":"Sassandra",
            "country":"Ivory Coast"
         },
         "departureDate":1670173639000,
         "flightTime":"08:56:57",
         "allSeats":236,
         "freeSeats":206,
         "price":1283.47,
         "company":{
            "id":13,
            "name":"SkyWest Airlines"
         },
         "distance_km":7874
      }
   ]
}
```

#### All airports

GET: `/airport/all` \
Return all airports with fields:
* code
* city
* country

### Company

#### Company by ID

GET: `/company/flights/{id}` \
Return:
* list of flights for company with id = {id}

Here is sample output:
  \
  `curl localhost:8082/company/flights/3`
```
[
   {
      "id":40,
      "departureAirport":{
         "code":"GNV",
         "city":"Gainesville, FL",
         "country":"USA"
      },
      "arrivalAirport":{
         "code":"ILM",
         "city":"Wilmington, NC",
         "country":"USA"
      },
      "departureDate":1686045276000,
      "flightTime":"07:09:03",
      "allSeats":320,
      "freeSeats":178,
      "price":1802.46,
      "company":{
         "id":3,
         "name":"Virgin Blue Airlines"
      },
      "distance_km":654
   },
   {
      "id":73,
      "departureAirport":{
         "code":"OSH",
         "city":"Oshkosh, WI",
         "country":"USA"
      },
      "arrivalAirport":{
         "code":"KUH",
         "city":"Kushiro",
         "country":"Japan"
      },
      "departureDate":1671887093000,
      "flightTime":"06:34:24",
      "allSeats":285,
      "freeSeats":33,
      "price":656.65,
      "company":{
         "id":3,
         "name":"Virgin Blue Airlines"
      },
      "distance_km":9011
   }
]
```


### Flight

#### Flight by ID

GET: `/flight/{id}` \
Return:
* departure airport
* arrival airport
* departure date
* flight time
* all seats
* free seats
* price
* company

Here is sample output:
  \
  `curl localhost:8082/flights/3`
```
{
   "id":3,
   "departureAirport":{
      "code":"BMA",
      "city":"Stockholm - Bromma",
      "country":"Sweden"
   },
   "arrivalAirport":{
      "code":"PIT",
      "city":"Pittsburgh",
      "country":"USA"
   },
   "departureDate":1677481771000,
   "flightTime":"04:52:58",
   "allSeats":167,
   "freeSeats":30,
   "price":1490.14,
   "company":{
      "id":68,
      "name":"Air Canada"
   },
   "distance_km":6645
}
```

#### Flight by airport codes

GET: `/flight/{departureCode}/{arrivalCode}?date={date}` \
parameters:
* date - date of flight in format "YYYY-MM-DD"

Return:
* list of flights

Here is sample output:
  \
  `curl localhost:80822/flight/CXI/ABY?date=2023-05-18`
```
[
   {
      "id":120,
      "departureAirport":{
         "code":"CXI",
         "city":"Christmas Line",
         "country":"Iceland"
      },
      "arrivalAirport":{
         "code":"ABY",
         "city":"Albany, GA",
         "country":"USA"
      },
      "departureDate":1684439963000,
      "flightTime":"09:10:01",
      "allSeats":313,
      "freeSeats":1,
      "price":90.0,
      "company":{
         "id":64,
         "name":"AirAsia"
      },
      "distance_km":8298
   }
]
```
