import mongoose from "mongoose";

mongoose
  .connect("mongodb://localhost:80", {
    useNewUrlParser: true,
    useCreateIndex: true,
    useFindAndModify: false,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("connection to DB");
  });
mongoose.Promise = global.Promise;
