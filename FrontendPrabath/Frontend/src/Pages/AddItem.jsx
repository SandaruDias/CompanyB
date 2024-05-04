import React from "react";
import "./../Styles/AddItem.css";
import { useState } from "react";

function AddItem() {
  const [itemDetails, setItemDetails] = useState({
    itemName: "",
    units: "",
    supplier: "",
    baseValue: "",
  });

  const handleChange = (event) => {
    setItemDetails((prev) => ({
      ...prev,
      [event.target.name]: event.target.value,
    }));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(itemDetails);
    setItemDetails({
      itemName: "",
      units: "",
      supplier: "",
      baseValue: "",
    });
  };
  return (
    <>
      <div className="add-item-container">
        <h1>Add Items.</h1>
        <div className="inputs">
          <input
            type="text"
            placeholder="Item Name"
            name="itemName"
            onChange={handleChange}
            value={itemDetails.itemName}
          />
        </div>
        <div className="inputs">
          <input
            type="text"
            placeholder="No of Units"
            name="units"
            onChange={handleChange}
            value={itemDetails.units}
          />
        </div>
        <div className="inputs">
          <input
            type="text"
            placeholder="Supplier"
            name="supplier"
            onChange={handleChange}
            value={itemDetails.supplier}
          />
        </div>
        <div className="inputs">
          <input
            type="text"
            placeholder="Base Value"
            name="baseValue"
            onChange={handleChange}
            value={itemDetails.baseValue}
          />
        </div>
        <button onClick={handleSubmit} className="add-button">
          Submit
        </button>
      </div>
    </>
  );
}

export default AddItem;
