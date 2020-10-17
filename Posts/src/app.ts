import express, { Request, Response, NextFunction } from "express";
const app = express();
import cors from "cors";
import morgan from "morgan";
import bodyParser from "body-parser";
import "./mongo/db";

import PostRouter from "./controllers/C_post";
import { ok } from "assert";

app.use(morgan("dev"));
app.use(cors());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use((req, res, next) => {
  res.header("Access-Control-Allow-Origin", "*");
  res.header(
    "Access-Control-Allow-Headers",
    "Origin, X-Requested-With, Content-Type, Accept, Authorization"
  );
  if (req.method === "OPTIONS") {
    res.header("Access-Control-Allow-Methods", "PUT, POST, PATCH, DELETE, GET");
    return res.status(200).json({});
  }
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
