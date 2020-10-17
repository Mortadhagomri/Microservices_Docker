import express from "express";
const router = express.Router();
import {
  createPost,
  deleteAllPosts,
  deletePost,
  getFakePost,
  getPosts,
  updatePost,
  getComments,
  getPostsForUser,
} from "./../services/S_post";

router.get("/fakePosts", getFakePost);
router.get("/post", getPosts);
router.post("/post", createPost);
router.patch("/post/:id", updatePost);
router.delete("/post/:id", deletePost);
router.delete("/deleteAll", deleteAllPosts);
router.get("/getComments/:id", getComments);
router.get("/getUserPosts/:userId", getPostsForUser);
export default router;
