import React from "react";
import { Link } from "react-router-dom";
import user_icon from "./../Images/User_Icon.png";
import "./../Styles/NavBar.css";

function NavBar() {
  return (
    <div id="menu">
      <div className="navbar-list">
        <ul>
          <li>
            <Link>Home</Link>
          </li>
          <li>
            <Link>About</Link>
          </li>
          <li>
            <Link className="dropdown-arrow">Company</Link>
            <ul className="sub-menus">
              <li>
                <Link>Company 1</Link>
              </li>
              <li>
                <Link>Company 2</Link>
              </li>
              <li>
                <Link>Company 3</Link>
              </li>
              <li>
                <Link>Company 4</Link>
              </li>
            </ul>
          </li>
          <li>
            <Link className="dropdown-arrow">Pages</Link>
            <ul className="sub-menus">
              <li>
                <Link>pages 1</Link>
              </li>
              <li>
                <Link>Pages 2</Link>
              </li>
              <li>
                <Link>Pages 3</Link>
              </li>
              <li>
                <Link>Pages 4</Link>
              </li>
            </ul>
          </li>

          <li>
            <Link className="dropdown-arrow">Services</Link>
            <ul className="sub-menus">
              <li>
                <Link>Services 1</Link>
              </li>
              <li>
                <Link>Services 2</Link>
              </li>
              <li>
                <Link>Services 3</Link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <div className="user-logo">
        <p>Hi! User</p>
        <img src={user_icon} alt="" />
      </div>
    </div>
  );
}

export default NavBar;
