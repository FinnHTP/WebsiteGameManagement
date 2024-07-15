import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';

const BlogComponent = () => {
//   const [groupId, setGroupId] = useState([])
  const [blogs, setBlogs] = useState([]);
    const {groupId} = useParams();
  useEffect(() => {
    findBlogsByGroup(groupId);
    console.log(groupId);
    // getGroup(groupId);
   
  }, [groupId]);


    // const url = window.location.href;
    // const lastSlashIndex = url.lastIndexOf('/');
    // const groupId2 = url.substring(lastSlashIndex+1);
 

 
//   const getGroup = async (groupId) => {
//     try {
//         const response = await axios.get(`http://localhost:8080/api/group/${groupId}`);
//         setGroupId(response.data);
//     } catch (error) {
//         console.error(error)
//     }
//   }


  const findBlogsByGroup = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/blogs/group/${groupId}`);
      setBlogs(response.data);
    } catch (error) {
      console.error('Error fetching blogs:', error);
    }
  };

  return (
    <div>
      {blogs.map(blog => (
        <div key={blog.id}>
          <h5>Bài viết được thực hiện bởi {blog.account.id}</h5>
          <span>Thời gian đăng: {blog.createDate}</span>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogComponent;
