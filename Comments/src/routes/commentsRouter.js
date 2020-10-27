const express = require("express");
const Comment = require("../models/Comment");
const fetch = require("node-fetch");
const router = express.Router();

router.get("/fill-DB", (req, res) => {
  fetch("https://jsonplaceholder.typicode.com/comments")
    .then((results) => results.json())
    .then((comments) => {
      const savedComments = comments.map(
        ({ id, body, email, postId, name }) => {
          return {
            _id: id,
            postId,
            email,
            userId: Math.floor(Math.random() * 10) + 1,
            body,
            name,
          };
        }
      );
      Comment.collection
        .insertMany(savedComments)
        .then(() => res.send("Completed"));
    });
});

router.get("/comments", (req, res) => {
  Comment.find({}).then((comments) => res.send(comments));
});

router.get("/comment/:id", (req, res) => {
  const { id } = req.params;
  Comment.findById(id).then((comment) => res.send(comment));
});

router.get("/deleteDB", (req, res) => {
  Comment.deleteMany({}).then(() => {
    res.send("DB deleted");
  });
});

router.get("/byUserId/:userId", (req, res) => {
  const { userId } = req.params;
  Comment.find({ userId }).then((comments) => res.send(comments));
});

router.get("/byPostId/:postId", (req, res) => {
  const { postId } = req.params;
  Comment.find({ postId }).then((comments) => res.send(comments));
});

module.exports = router;
