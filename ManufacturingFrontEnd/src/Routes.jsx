// ProjectRoutes.js
import React from "react";
import { useRoutes } from "react-router-dom";
import Home from "pages/Home";
import NotFound from "pages/NotFound";
import HomepageLoginAdmin from "pages/HomepageLoginAdmin";
import HomepageLoginWorkerOne from "pages/HomepageLoginWorkerOne";
import AdminInterface from "pages/AdminInterface";
import AdminInterfaceOne from "pages/AdminInterfaceOne";
import WorkersInterfaceone from "pages/WorkersInterfaceone";

const ProjectRoutes = () => {
  let element = useRoutes([
    { path: "/", element: <Home /> },
    { path: "*", element: <NotFound /> },
    {
      path: "homepageloginadmin",
      element: <HomepageLoginAdmin />,
    },
    {
      path: "homepageloginworkerone",
      element: <HomepageLoginWorkerOne />,
    },
    {
      path: "admininterface",
      element: <AdminInterface />,
    },
    {
      path: "admininterfaceone",
      element: <AdminInterfaceOne />,
    },
    {
      path: "workersinterfaceone",
      element: <WorkersInterfaceone />,
    },
  ]);

  return element;
};

export default ProjectRoutes;