// node app.js
const port = 3000;
const cors = require("cors");
const express = require("express");
const app = express();

app.use(cors({
    /* 設定 CORS 允許打你API的網域路徑 */
    "origin": ["http://localhost:5173", "http://localhost:4173"],
    "methods": "GET,POST"
}));

const mockTableHeader = require("./json_data/mockTableHeader.js");

const mockTableBody = require("./json_data/mockTableBody.js");

app.get("/", function (req, res) {
    res.send("Hello World");
});

app.get("/tableHeader", function (req, res) {
    res.send(mockTableHeader);
});

app.get("/tableBody", function (req, res) {
    res.send(mockTableBody);
});

app.listen(port, function () {
    console.log(`Example app listening on port ${port}`);
});