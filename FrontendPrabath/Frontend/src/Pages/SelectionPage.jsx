import React from 'react'
import { Link } from 'react-router-dom'
import './../Styles/Selection.css'

function SelectionPage() {
  return (
    <div className="login-container" style={{backgroundColor: "#c5c5c5"}}>
      <div className="login">
        <div className="details">
          <div className='home-button-container'>
            <button className='home-button'><Link to={"/home"} className="button-link" >Home</Link></button>
          
          </div>
          
          <h1 className="login-title">Select your role</h1>
          <Link to={"/companyB/manufacturing/adminPortal"} className="button-link">
  <h2><button className='admin-button'>Admin</button></h2>
</Link>
<Link to={"/companyB/manufacturing/workerportal"} className="button-link">
  <h2><button className='worker-button'>Worker</button></h2>
</Link>
        </div>  
      </div>
      </div>
  );
  
}

export default SelectionPage
