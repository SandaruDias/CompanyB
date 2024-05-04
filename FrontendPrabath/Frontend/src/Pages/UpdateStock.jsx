import React, { useState } from "react";
import Select from "react-dropdown-select";
import "./../Styles/UpdateStock.css";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";

function UpdateStock() {
  const [values, setValues] = useState("");
  const [quantity, setQuantity] = useState();
  const history = useHistory();

  const options = [
    {
      value: 1,
      label: "Product 01",
    },
    {
      value: 2,
      label: "Product 02",
    },
    {
      value: 3,
      label: "Product 03",
    },
    {
      value: 4,
      label: "Product 04",
    },
    {
      value: 5,
      label: "Product 05",
    },
  ];

  const handSubmit = () => {
    console.log({ Product: values[0].label, Quantity: quantity });
    //pass data to the database
    history.push("/StockManag");
  };
  console.log(values);
  return (
    <div className="update-stock-container">
      <h1
        style={{
          textAlign: "center",
          marginTop: 0,
          fontSize: "3rem",
        }}
      >
        Update Stock
      </h1>
      <Select
        options={options}
        onChange={(values) => setValues(values)}
        placeholder="Select Product"
        searchable={true}
        clearable={true}
        style={
          ({ width: "100%" },
          { fontSize: "20px" },
          { backgroundColor: "white" },
          { fontSize: "20px" })
        }
      />
      <input
        className="update-stock-input"
        type="number"
        placeholder="Quantity"
        name="quantity"
        onChange={(e) => setQuantity(e.target.value)}
        value={quantity}
      />
      <button className="update-stock-button" onClick={handSubmit}>
        Update Stock
      </button>
    </div>
  );
}

export default UpdateStock;
