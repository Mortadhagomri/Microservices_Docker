const express = require("express");
const router = require("./routes/commentsRouter");
const app = express();
require("./db/db");
const port = 8080;

app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*"); // update to match the domain you will make the request from
  next();
});

const route = require("./routes/commentsRouter");
app.use(route);
app.listen(port, () => {
  console.log(`listenning to ${port}`);
});
