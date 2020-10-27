import PostModel, { Post, Comment } from "./../models/Post";
import { RequestHandler } from "express";
import fetch from "node-fetch";

export const getPosts: RequestHandler = (req, res) => {
  PostModel.find().then((results) => res.send(results));
};

export const createPost: RequestHandler = (req, res) => {
  const postR: Post = req.body;
  const post = new PostModel(postR);
  post.save().then((response: Post) => res.send(response));
};

export const updatePost: RequestHandler<{ id: string }> = async (req, res) => {
  const { id } = req.params;
  const body = req.body as Post;
  PostModel.findByIdAndUpdate(id, body, { new: true }, (err, post) => {
    if (!err) {
      res.send(post);
    }
  });
};

export const deletePost: RequestHandler<{ id: string }> = (req, res) => {
  const { id } = req.params;
  PostModel.findByIdAndRemove(id).then((post) => res.send(post));
};

export const deleteAllPosts: RequestHandler = (req, res) => {
  PostModel.deleteMany({}).then((result) => res.json(result));
};

export const getFakePost: RequestHandler = (req, res) => {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((fakeposts: any[]) => {
      fakeposts.map(({ title, body, id, userId }) => {
        const post = new PostModel({
          _id: id,
          title,
          body,
          userId,
        });
        post.save();
      });
      res.send("Saved Posts in DB ");
    })
    .catch((e) => {
      throw Error(e.message);
    });
};

export const getComments: RequestHandler<{ id: Number }> = async (req, res) => {
  const { id } = req.params;
  fetch(`http://comments_container:8080/byPostId/${id}`)
    .then((response) => response.json())
    .then((comments: Comment[]) => res.send(comments));
};

export const getPostsForUser: RequestHandler<{ userId: String }> = (
  req,
  res
) => {
  const { userId } = req.params;
  PostModel.find({ userId }).then((response: Post[]) => res.json(response));
};
