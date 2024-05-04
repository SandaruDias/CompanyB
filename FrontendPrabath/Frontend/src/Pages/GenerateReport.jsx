import React from "react";
import "./../Styles/GenerateReport.css";

function GenerateReport() {
  const data = [
    {
      ID: 1,
      Name: "Product 01",
      Units: "10",
      Supplier: "Supplier 01",
      BaseValue: "50",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 01",
    },
    {
      ID: 2,
      Name: "Product 02",
      Units: "20",
      Supplier: "Supplier 02",
      BaseValue: "100",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 02",
    },
    {
      ID: 3,
      Name: "Product 03",
      Units: "30",
      Supplier: "Supplier 03",
      BaseValue: "150",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 03",
    },
    {
      ID: 4,
      Name: "Product 04",
      Units: "40",
      Supplier: "Supplier 04",
      BaseValue: "200",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 04",
    },
    {
      ID: 5,
      Name: "Product 05",
      Units: "50",
      Supplier: "Supplier 05",
      BaseValue: "250",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 05",
    },
    {
      ID: 6,
      Name: "Product 06",
      Units: "60",
      Supplier: "Supplier 06",
      BaseValue: "300",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 06",
    },
    {
      ID: 7,
      Name: "Product 07",
      Units: "70",
      Supplier: "Supplier 07",
      BaseValue: "350",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 07",
    },
    {
      ID: 8,
      Name: "Product 08",
      Units: "80",
      Supplier: "Supplier 08",
      BaseValue: "400",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 08",
    },
    {
      ID: 9,
      Name: "Product 09",
      Units: "90",
      Supplier: "Supplier 09",
      BaseValue: "450",
      CreatedDate: "01/01/2022",
      UpdatedDate: "01/01/2022",
      UpdatedUser: "Name 09",
    },
  ];

  return (
    <div className="container">
      <h2>Stock Managment Report</h2>
      <ul className="responsive-table">
        <li className="table-header">
          <div className="col col-1">Id</div>
          <div className="col col-2">Name</div>
          <div className="col col-3">Units</div>
          <div className="col col-4">Supplier</div>
          <div className="col col-5">BaseValue</div>
          <div className="col col-7">CreatedDate</div>
          <div className="col col-8">UpdatedDate</div>
          <div className="col col-9">UpdatedUser</div>
        </li>
        {data.map((item, index) => (
          <li key={index} className="table-row">
            <div
              className="col col-1"
              data-label="Id"
              style={{ textAlign: "left" }}
            >
              {item.ID}
            </div>
            <div
              className="col col-2"
              data-label="Name"
              style={{ textAlign: "left" }}
            >
              {item.Name}
            </div>
            <div
              className="col col-3"
              data-label="Units"
              style={{ textAlign: "left", marginLeft: "30px" }}
            >
              {item.Units}
            </div>
            <div
              className="col col-4"
              data-label="Supplier"
              style={{ textAlign: "left", marginLeft: "30px" }}
            >
              {item.Supplier}
            </div>
            <div
              className="col col-5"
              data-label="BaseValue"
              style={{ textAlign: "left", marginLeft: "30px" }}
            >
              {item.BaseValue}
            </div>
            <div
              className="col col-6"
              data-label="CreatedDate"
              style={{ marginLeft: "30px", textAlign: "left" }}
            >
              {item.CreatedDate}
            </div>
            <div className="col col-7" data-label="UpdatedDate">
              {item.UpdatedDate}
            </div>
            <div className="col col-8" data-label="UpdatedUser">
              {item.UpdatedUser}
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default GenerateReport;
