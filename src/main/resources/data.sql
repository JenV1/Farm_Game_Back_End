

INSERT INTO FARMS (NAME, FUNDS, DATE) VALUES ('Bamfurlong', 1000, 0);
INSERT INTO FARMS (NAME, FUNDS, DATE) VALUES ('OldMcDonalds', 200, 0);
INSERT INTO FARMS (NAME, FUNDS, DATE) VALUES ('Underhill', 200, 0);
INSERT INTO FARMS (NAME, FUNDS, DATE) VALUES ('HighMill', 200, 0);


INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ( 'Wheat', 20, 300, 20, 35);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Corn', 20, 300, 20, 50);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Rye', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Rice', 20, 300, 20, 50);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Sunflowers', 20, 300, 20, 60);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Lavender', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Potatoes', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Cabbages', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Leeks', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Tomatoes', 20, 300, 20, 30);
INSERT INTO CROPS (NAME, PRICE, STOCK, GROWTIME, SELLPRICE) VALUES ('Carrots', 20, 300, 20, 30);


INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('small field', 2, 10, null);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('tiny field', 1, 5, null);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('medium field', 4, 20, null);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('large field', 8, 40, null);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('huge field', 16, 80, null);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('small beach', 2, 8, 5);
INSERT INTO FIELD_TYPES (NAME, SIZE, COST, SOILTYPE) VALUES ('beach', 8, 30, 5);


INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('lower river', 0, 1, 1, 1, 8);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('upper river', 0, 3, 4, 1, 2);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('downstream', 0, 3, 1, 2, 2);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('hilly meadow', 0, 1, 3, 3, 3);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('marshy meadow', 0, 2, 7, 3, 1);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('flat meadow', 0, 3, 8, 4, 8);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('just a field', 0, 5, 5, 4, 5);
INSERT INTO FIELDS (NAME, TIMELEFT, FIELD_ID, CROP_ID, FARM_ID, SOILTYPE) VALUES ('field not found', 0, 2, 4, 4, 1);

INSERT INTO CROP_SOIL_TYPES (CROP_ID, SOIL_TYPES) VALUES (1, 1);
INSERT INTO CROP_SOIL_TYPES (CROP_ID, SOIL_TYPES) VALUES (1, 8);
INSERT INTO CROP_SOIL_TYPES (CROP_ID, SOIL_TYPES) VALUES (2, 8);
INSERT INTO CROP_SOIL_TYPES (CROP_ID, SOIL_TYPES) VALUES (3, 5);

INSERT INTO CROP_SOIL_EFFECTS (CROP_ID, SOIL_EFFECTS) VALUES (1, 2);
INSERT INTO CROP_SOIL_EFFECTS (CROP_ID, SOIL_EFFECTS) VALUES (1, 3);
INSERT INTO CROP_SOIL_EFFECTS (CROP_ID, SOIL_EFFECTS) VALUES (2, 3);
INSERT INTO CROP_SOIL_EFFECTS (CROP_ID, SOIL_EFFECTS) VALUES (3, 1);
