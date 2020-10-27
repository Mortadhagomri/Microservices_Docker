const mongoose = require("mongoose");

const commentSchema = new mongoose.Schema({
  _id: Number,
  userId: Number,
  postId: Number,
  body: String,
  name: String,
  email: String,
});

commentSchema.methods.toJSON = function () {
  const commesnt = this;
  const commesntP = commesnt.toObject();
  commesntP.id = commesntP._id;
  delete commesntP._id;
  return commesntP;
};

const Comment = mongoose.model("Comment", commentSchema);

module.exports = Comment;
