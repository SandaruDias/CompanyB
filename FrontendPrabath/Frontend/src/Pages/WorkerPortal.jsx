import React, { useState } from "react";
import "./../Styles/Login.css";
import Select from "react-dropdown-select";

function WorkerPortal() {
  const [details, setDetails] = useState({ username: "", password: "" });
  const [selectedValue, setSelectedValue] = useState([]);

  // Updated options for Select dropdown with Work Stations
  const options = [
    { label: "Work Station 1", value: "work_station_1" },
    { label: "Work Station 2", value: "work_station_2" },
    { label: "Work Station 3", value: "work_station_3" }
  ];

  const handleChange = (event) => {
    setDetails(prev => ({
      ...prev,
      [event.target.name]: event.target.value
    }));
  };

  const handleSelectChange = (values) => {
    setSelectedValue(values);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(details);
    console.log(selectedValue);
    // Setup validation
    // Pass to database
    setDetails({ username: "", password: "" });
  };

  return (
    <div className="login-container">
      <div className="login">
        <div className="details">
          <h1 className="login-title">Worker Portal.</h1>
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
          <div>
            <Select
              options={options}
              onChange={handleSelectChange}
              placeholder="Select Work Station"
              searchable={true}
              clearable={true}
              style={{
                width: '100%',
                fontSize: '16px',
                backgroundColor: 'white',
              }}
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

export default WorkerPortal;
