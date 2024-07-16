import React, { useEffect } from "react";
import { GoogleLogin } from "react-google-login";
import { gapi } from "gapi-script";

const clientId =
  "1081788377089-pp55hprpqvbrbbo3fr082nj3t0oe3e79.apps.googleusercontent.com";

const GoogleLoginButton = () => {
  useEffect(() => {
    gapi.load("client:auth2", () => {
      gapi.client.init({
        clientId: "*****.apps.googleusercontent.com",
        plugin_name: "chat",
      });
    });
  }, []);

  const responseGoogle = async (response) => {
    if (response.error && response.error === "popup_closed_by_user") {
      console.error("Popup closed by user");
      return;
    }

    const { credential } = response;

    try {
      const res = await fetch("http://localhost:8080/loginSuccess", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${credential.accessToken}`,
        },
      });

      if (res.ok) {
        const data = await res.json();
        console.log("JWT Token:", data.token);
        localStorage.setItem("accessToken", data.token);
        window.location.href = "/profile"; // Chuyển hướng đến trang profile sau khi đăng nhập thành công
      } else {
        console.error("Đăng nhập thất bại");
        // Xử lý trường hợp đăng nhập không thành công
      }
    } catch (error) {
      console.error("Lỗi đăng nhập:", error);
    }
  };

  return (
    <GoogleLogin
      clientId={clientId}
      onSuccess={responseGoogle}
      onFailure={(error) => console.error("Google login failed:", error)}
      cookiePolicy={"single_host_origin"}
    />
  );
};

export default GoogleLoginButton;
