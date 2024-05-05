import React, { useState } from "react";
import "./../Styles/WorkerPortal.css";
import Select from "react-dropdown-select";
import { useHistory } from "react-router-dom"; // Import useHistory from react-router-dom
import axios from "axios"
import { Link } from "react-router-dom";


function WorkerPortal() {
  const [details, setDetails] = useState({ username: "", password: "", workStation: "" });
  const [selectedValue, setSelectedValue] = useState([]);
  const history = useHistory(); // Create a history object

  // Updated options for Select dropdown with Work Stations
  const options = [
    { label: "Work Station 1", value: "1" },
    { label: "Work Station 2", value: "2" },
    { label: "Work Station 3", value: "3" }
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

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(details);
    try {
      const response = await axios.put(`http://localhost:8090/companyB/manufacturing/User/workstationLogin/${details.workStation}/${details.username}/${details.password}`);
      console.log(response.data); // Log the response data
      if(response.data === "Login Successful"){
        if(details.workStation==="1"){
          history.push("/WorkStationOne")
        }
        if(details.workStation==="2"){
          history.push("/WorkStationTwo")
        }
        if(details.workStation==="3"){
          history.push("/WorkStationThree")
        }


      } else {
        // Handle other cases if needed
        alert("Login failed: " + response.data);
      }
      

      // Reset the form after successful login
      setDetails({ username: "", password: "", workStation: details.workStation });
    } catch (error) {
      console.error('Error logging in:', error.message);
      // You can handle errors here, such as displaying an error message to the user
    }
    // Setup validation
    // Pass to database

    

  };

  return (
    <div className="login-container" style={{backgroundColor : "#c5c5c5"}}>
      <div className="login">
        <div className="details">
        <div className="navigation-bar">
        <Link to={"/companyB/manufacturing"} style={{textDecoration: "none", color: "white"}} ><button  className="home-button">Selection Page</button> </Link>
        <Link to={"/home"} style={{textDecoration: "none", color: "white"}}><button className="home-button">Home Page</button> </Link>
             
          </div>
          <h1 className="login-title">Worker Portal</h1>
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
                width: '104%',
                fontSize: '16px',
                backgroundColor: 'white',
              }}
            />
          </div>
          <button style={{
                padding: "11px"
              }} className="login-button" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}

export default WorkerPortal;
