const mongoose = require("mongoose");

mongoose
  .connect("mongodb://commentsdb", {
    useFindAndModify: false,
    useUnifiedTopology: true,
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => console.log("connecting to DB"));
