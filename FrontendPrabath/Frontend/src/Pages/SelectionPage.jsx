import React from 'react'
import { Link } from 'react-router-dom'
import './../Styles/Selection.css'

function SelectionPage() {
  return (
    <><div className='selection-container'>
      <button className='admin-button'><Link to={"/adminPortal"}>Admin Portal</Link></button>
    </div><div className='selection-container'>
        <button className='worker-button'><Link to={"/workerPortal"}>Worker Portal</Link></button>
      </div></>
  )
}

export default SelectionPage
