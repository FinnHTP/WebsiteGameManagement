import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { jwtDecode } from 'jwt-decode';
const BlogComponent = () => {
//   const [groupId, setGroupId] = useState([])
  const [blogs, setBlogs] = useState([]);
  const [idblog, setIdblog] = useState([]);
  const [content, setContent] = useState("");
  const [parentId, setParentId] = useState(null); // State to store parentId
  const { id } = useParams();
    const {groupId} = useParams();
  useEffect(() => {
    listAllComments();
    findBlogsByGroup(groupId);
 
    // getGroup(groupId);

  }, [groupId]);
  const [comments, setComments] = useState([]);

  const buildCommentTree = (comments) => {
    const map = {};
    const roots = [];

    comments.forEach((comment) => {
      map[comment.id] = { ...comment, children: [] };
    });
  }
  const commentTree = buildCommentTree(comments);

  const handleReply = (comment) => {
    setParentId(comment.id); 
    setContent(`${comment.account.email} `); //
  };

  const renderComments = (comments) => {
    return comments.map((comment) => (
      <div key={comment.id} className="comment mt-4 text-justify">
        <img
          src="https://cdn-icons-png.flaticon.com/128/149/149071.png"
          width={55}
          height={55}
          alt=""
        />
        <h4>{comment.account ? comment.account.email : "Anonymous"}</h4>
        <span>{comment.date}</span>
        <br />
        <p>{comment.content}</p>
        <a
          onClick={() => handleReply(comment)}
          className="btn-reply"
          style={{ fontSize: "1.3rem", color: "blue" }}
        >
          Reply
        </a>
        {comment.children.length > 0 && (
          <div className="comment-child" style={{ marginLeft: "45px" }}>
            {renderComments(comment.children)}
          </div>
        )}
      </div>
    ));
  };


  const findBlogsByGroup = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/blogs/group/${groupId}`);
      setBlogs(response.data);
    } catch (error) {
      console.error('Error fetching blogs:', error);
    }
  };

  const createCommentAndRefreshList = async (e) => {
    const token = localStorage.getItem("accesstoken");
    if (token) {
      e.preventDefault();
      try {
        const decodedToken = jwtDecode(token);
        const accountId = decodedToken.id;
        const accountEmail = decodedToken.email;

        const comment = {
          account: { id: accountId, email: accountEmail },
          content,
          parentId: parentId,
        };

        if (!token) {
          throw new Error("Không có token được tìm thấy");
        }

        const response = await axios.post(
          `http://localhost:8080/api/blogs/group/${groupId}/${id}`,
          comment,
          {
            headers: {
              "Content-Type": "application/json",
              Authorization: `Bearer ${token}`,
            },
          }
        );

        setComments([...comments, response.data]);
        setContent("");
        setParentId(null);
      } catch (error) {
        console.error("Lỗi khi gửi bình luận:", error);
      }
    }
  };

  const handleContent = (e) => setContent(e.target.value);

  const listAllComments = async () => {
    const token = localStorage.getItem("accesstoken");

    if (!token) {
      console.error("Token Not Found");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/api/commentblog/blog/${id}`,
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );

      const data =
        typeof response.data === "string"
          ? JSON.parse(response.data)
          : response.data;

      setComments(Array.isArray(data) ? data : []);
    } catch (error) {
      console.error("Fail to Request", error);
    }
  };



  return (
    <div>
      <div className='container'>
    <div className='row'>
        <div className=' col-xl-8 col-md-8 p-4' style={{marginTop:'50px',border: "1px solid #ccc",
                
                borderRadius: "10px",}}>
      {blogs.map(blog => (
        <div key={blog.id}>
          <h5 style={{marginLeft:'10%'}}>Bài viết được thực hiện bởi {blog.account.email} </h5>
          <span style={{fontSize:'10px',marginLeft:'35%'}}>Thời gian đăng: {blog.createDate}</span>
          
          <p>{blog.content}</p>
        </div>
      ))}
     </div>


     <div className='col-xl-3'>
      <h5>Chỗ này load game liên quan</h5>
     </div>
     </div>



     <div className="form-group">
                  <h5>Comment</h5>
                  <textarea
                    name="msg"
                    id="msg"
                    cols="30"
                    rows="5"
                    className="form-control-textarea"
                    onChange={handleContent}
                    value={content}
                  ></textarea>
                </div>


                <div className="form-group">
                  <button
                    type="button"
                    id="post"
                    className="btn"
                    onClick={createCommentAndRefreshList}
                  >
                    Send
                  </button>
                </div>

                <h5
                style={{
                  borderBottom: "1px solid #ccc",
                  paddingBottom: "10px",
                }}
              ></h5>
              {comments.length === 0 ? (
                <p
                  style={{
                    textAlign: "center",
                    fontSize: "1.6rem",
                    marginTop: "30px",
                  }}
                >
                  Leave Your Comment Here.
                </p>
              ) : (
                renderComments(commentTree)
              )}
     </div>
    </div>
    
  );
};

export default BlogComponent;
