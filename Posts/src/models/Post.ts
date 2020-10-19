import { Document, Model, model, Schema } from "mongoose";

export class Post {
  constructor(userId: Number, title: String, body: String, id?: Number) {}
}

export interface Comment {
  postId: Number;
  id: Number;
  name: String;
  email: String;
  body: String;
}

export interface PostDocument extends Post, Document {}

const postSchema: Schema = new Schema({
  _id: Number,
  userId: { type: Number, required: true },
  title: { type: String, required: true },
  body: { type: String, required: true },
});

postSchema.methods.toJSON = function () {
  const post = this;
  const postP = post.toObject();
  postP.id = postP._id;
  delete postP._id;
  return postP;
};
export default model<PostDocument>("Post", postSchema);
