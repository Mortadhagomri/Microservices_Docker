const express = require("express");

const router = express.Router();

router.get("/fill-DB", (req, res) => {
  fetch("https://jsonplaceholder.typicode.com/comments").then((comments) => {});
});

module.exports = router;
