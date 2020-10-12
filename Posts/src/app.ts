import express, { Request, Response, NextFunction } from "express";
const app = express();
import cors from "cors";
import morgan from "morgan";
import bodyParser from "body-parser";

app.use(morgan("dev"));
app.use(cors());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

const port: number = 4000;

app.use((err: Error, req: Request, res: Response, next: NextFunction) => {
  res.status(500).json({ message: err.message });
});
app.listen(port, () => {
  console.log(`Listening on port ${port}`);
});
