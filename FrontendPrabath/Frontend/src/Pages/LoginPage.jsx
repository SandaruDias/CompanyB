import React, { useState } from "react";
import "./../Styles/Login.css";



function LoginPage() {
  const [details, setDetails] = useState({ username: "", password: "" });

  const handleChange = (event) => {
    setDetails((prev) => ({
      ...prev,
      [event.target.name]: event.target.value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(details);
    //setup vaidation
    //pass to database
    setDetails({ username: "", password: "" });
  };

  return (
    <div className="login-container">
      <div className="login">
        <div className="details">
          <h1 className="login-title">Admin Portal</h1>
          <div className="username">
            <input
              type="text"
              placeholder="Username"
              name="username"
              onChange={handleChange}
              value={details.username}
            />
          </div>
          <div className="password">
            <input
              type="password"
              placeholder="Password"
              name="password"
              onChange={handleChange}
              value={details.password}
            />
          </div>
          <button className="login-button" onClick={handleSubmit}>
            Login
          </button>
        </div>

      </div>
    </div>
  );
}

export default LoginPage;
