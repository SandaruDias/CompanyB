import React, { useState } from "react";
import "./../Styles/WorkerPortal.css";
import Select from "react-dropdown-select";
import { useHistory } from "react-router-dom"; // Import useHistory from react-router-dom

function WorkerPortal() {
  const [details, setDetails] = useState({ username: "", password: "", workStation: "" });
  const [selectedValue, setSelectedValue] = useState([]);
  const history = useHistory(); // Create a history object

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
    // Assuming single selection, so getting the first selected value
    const selectedStation = values.length > 0 ? values[0].value : "";
    setDetails(prev => ({
      ...prev,
      workStation: selectedStation
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(details);
    // Setup validation
    // Pass to database

    setDetails({ username: "", password: "", workStation: "" });

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
                width: '80%',
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
