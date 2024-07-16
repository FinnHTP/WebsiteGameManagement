import axios from 'axios';
import React, { useState } from 'react';

const uploadAvatar = async (userId, file, token) => {
    const formData = new FormData();
    formData.append('avatar', file);

    try {
        const response = await axios.post(`http://localhost:8080/${userId}/avatar`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data',
                'Authorization': `Bearer ${token}`
            }
        });
        console.log('Avatar uploaded successfully:', response.data);
    } catch (error) {
        console.error('Failed to upload avatar:', error.response ? error.response.data : error.message);
    }
};

const getAvatar = async (userId, token) => {
    try {
        const response = await axios.get(`http://localhost:8080/${userId}/avatar`, {
            responseType: 'arraybuffer',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        const blob = new Blob([response.data], { type: response.headers['content-type'] });
        const url = URL.createObjectURL(blob);

        return url; // Trả về URL để bạn có thể sử dụng trong thẻ <img>
    } catch (error) {
        console.error('Failed to get avatar:', error.response ? error.response.data : error.message);
    }
};

const AvatarUploader = ({ userId, token }) => {
    const [avatarUrl, setAvatarUrl] = useState(null);
    const [selectedFile, setSelectedFile] = useState(null);

    const handleFileChange = (e) => {
        setSelectedFile(e.target.files[0]);
    };

    const handleUpload = async () => {
        if (selectedFile) {
            await uploadAvatar(userId, selectedFile, token);
            const url = await getAvatar(userId, token);
            setAvatarUrl(url);
        }
    };

    return (
        <div>
            <input type="file" onChange={handleFileChange} />
            <button onClick={handleUpload}>Upload Avatar</button>
            {avatarUrl && <img src={avatarUrl} alt="User Avatar" />}
        </div>
    );
};

export default AvatarUploader;
