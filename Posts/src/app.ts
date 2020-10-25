import express, { Request, Response, NextFunction } from "express";
const app = express();
/*import cors from "cors";
import morgan from "morgan";
import bodyParser from "body-parser";*/
import "./mongo/db";

import PostRouter from "./controllers/C_post";


/*app.use(morgan("dev"));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());*/


app.use(function (req, res, next) {
  res.header("Access-Control-Allow-Origin", "*"); // update to match the domain you will make the request from
  next();
});


app.use(PostRouter);

const port: number = 4000;

app.use((err: Error, req: Request, res: Response, next: NextFunction) => {
  res.status(500).json({ message: err.message });
});
app.listen(port, () => {
  console.log(`Listening on port ${port} `);
});
