import React, { useState } from "react";
import { Helmet } from "react-helmet";
import { Button, Heading, Input } from "../../components";
import Header from "../../components/Header";
import axios from "axios";

export default function WorkersInterfaceonePage() {
 

  const api = "http://localhost:8090";

  const [orderId, setOrderId] = useState('');

  // const handleTest = async () => {
  //   try {
  //     const response = await axios.get(`${api}/FetchOrders/${orderId}`);
  //     console.log(response.data); // Assuming the response contains the data you want to log
  //   } catch (err) {
  //     console.log(err);
  //   }
  // };
  const handleChange = (event) => {
    console.log(event.target.value)
  };
  return (
    <>
      <Helmet>
        <title>assemblyline</title>
        <meta name="description" content="Web site created using create-react-app" />
      </Helmet>
      <div className="flex h-[1024px] w-full flex-col items-center bg-[url(/public/images/img_home_page_login.png)] bg-cover bg-no-repeat pb-[76px] md:h-auto md:pb-5">
        <Header className="flex items-center justify-center self-stretch bg-black-900_7f_01 py-2.5 md:flex-col" />
        <div className="flex w-[92%] flex-col items-start md:w-full md:p-5">
          <Heading size="md" as="h1" className="self-center text-center capitalize">
            Workstation 01
          </Heading>
          <div className="mt-7 flex w-[87%] items-start justify-between gap-5 md:w-full md:flex-col">
            <div className="mt-5 flex w-[45%] items-start justify-center gap-[15px] md:w-full sm:flex-col">
              <Heading as="h2" className="mt-[13px] !font-extrabold capitalize">
              Order Id{" "}
              </Heading>
              <Input
                shape="round"
                name="orderId"
                className="mb-[5px] flex-grow sm:px-5"
                placeholder="Add Order ID"
                onChange={handleChange}
                value={orderId}
                type="text"
              />

              <Button size="xs" shape="square" className="min-w-[134px] font-extrabold" onClick={handleChange}>
                Submit
              </Button>
            </div>
            <div className="flex w-[40%] justify-center bg-blue_gray-100_33 p-[15px] md:w-full">
              <div className="mb-5 flex w-full flex-col items-start gap-[11px]">
                <Heading as="h3" className="ml-2 !font-extrabold capitalize md:ml-0">
                  Order Id{" "}
                </Heading>
                <div className="flex items-start gap-[29px] self-stretch sm:flex-col">
                  <Input shape="round" name="edittext_one" className="flex-grow sm:px-5" />
                  <Button size="xs" className="min-w-[134px] rounded-[15px] font-extrabold sm:pr-5">
                    Add{" "}
                  </Button>
                </div>
              </div>
            </div>
          </div>
          <div className="flex w-[90%] items-start justify-between gap-5 md:w-full md:flex-col">
            <div className="relative mb-[30px] h-[68px] w-[39%] md:w-full">
              <div className="absolute bottom-[-0.32px] left-0 right-0 m-auto flex w-[94%] items-center sm:relative sm:flex-col">
                <div className="h-[26px] w-[26px] rounded-[13px] border-[3px] border-solid border-white-A700 bg-white-A700" />
                <div className="relative z-[1] ml-[-2px] h-[8px] flex-1 border-[3px] border-solid border-white-A700 bg-white-A700 sm:ml-0 sm:self-stretch" />
                <div className="relative ml-[-3px] h-[26px] w-[26px] rounded-[13px] border-[3px] border-solid border-white-A700 bg-white-A700 sm:ml-0" />
                <div className="relative z-[2] ml-[-2px] h-[8px] flex-1 border-[3px] border-solid border-white-A700 sm:ml-0 sm:self-stretch" />
                <div className="relative ml-[-1px] h-[26px] w-[26px] self-start rounded-[13px] border-[3px] border-solid border-white-A700 sm:ml-0" />
              </div>
              <div className="absolute left-0 right-0 top-[0.00px] m-auto flex w-full flex-wrap items-start justify-between gap-5">
                <Heading as="h2" className="mb-[5px] capitalize">
                  Start
                </Heading>
                <Heading as="h3" className="text-center capitalize">
                  Process
                </Heading>
                <Heading as="h4" className="text-center capitalize">
                  End
                </Heading>
              </div>
            </div>
            <div className="h-[43px] w-[53%] border-8 border-solid border-white-A700" />
          </div>
          <div className="ml-[15px] mt-32 flex items-start justify-between gap-5 self-stretch md:ml-0 md:flex-col">
            <div className="flex w-[35%] rounded-[31px] bg-black-900_7f p-[38px] md:w-full sm:p-5">
              <Heading as="h2" className="mb-[11px] mt-[43px] w-[75%] capitalize leading-[121.02%]">
                <>
                  No of items :<br />
                  <br />
                  Completed Items : <br />
                  <br />
                  Remaining Items : <br />
                  <br />
                  Errors :{" "}
                </>
              </Heading>
            </div>
            <div className="mt-[38px] flex w-[57%] flex-col items-center gap-[76px] md:w-full md:gap-[57px] sm:gap-[38px]">
              <div className="flex items-center gap-[30px] self-stretch md:flex-col">
                <Heading as="h3" className="!font-black capitalize">
                  No of items :{" "}
                </Heading>
                <Input size="md" name="edittext_two" className="w-full rounded-[16px] sm:px-5" />
                <Heading as="h4" className="!font-extrabold capitalize">
                  No of items :{" "}
                </Heading>
                <Input size="md" name="edittext_three" className="w-full rounded-[16px] sm:px-5" />
              </div>
              <div className="flex w-[85%] justify-between gap-5 md:w-full sm:flex-col">
                <div className="relative h-[97px] w-[44%] rounded-[16px] border-[6px] border-solid border-white-A700 md:h-auto sm:w-full">
                  <Heading as="h5" className="text-center capitalize tracking-[5.20px]">
                    PASS
                  </Heading>
                  <div className="absolute bottom-0 left-0 right-0 top-0 m-auto flex h-max w-full justify-center rounded-[16px] border-[6px] border-solid border-white-A700 p-[26px] sm:p-5">
                    <Heading as="h6" className="text-center capitalize tracking-[5.20px]">
                      PASS
                    </Heading>
                  </div>
                </div>
                <Button
                  size="3xl"
                  variant="outline"
                  color="undefined_undefined"
                  className="min-w-[279px] rounded-[16px] font-extrabold tracking-[5.20px] sm:px-5"
                >
                  RECIEVE
                </Button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
