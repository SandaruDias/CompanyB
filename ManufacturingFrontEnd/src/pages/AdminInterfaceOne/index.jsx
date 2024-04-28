import React from "react";
import { Helmet } from "react-helmet";
import { Button, Heading, Img, Text, Input } from "../../components";
import Header from "../../components/Header";

export default function AdminInterfaceOnePage() {
  return (
    <>
      <Helmet>
        <title>assemblyline</title>
        <meta name="description" content="Web site created using create-react-app" />
      </Helmet>
      <div className="flex h-[1024px] w-full flex-col bg-[url(/public/images/img_home_page_login.png)] bg-cover bg-no-repeat md:h-auto">
        <Header className="flex items-center justify-between gap-5 bg-black-900_7f_01 p-2.5 md:flex-col" />
        <div className="relative mx-auto h-[889px] w-full max-w-[1386px] md:p-5">
          <div className="absolute bottom-0 left-[0.00px] top-0 my-auto flex h-max w-[63%] flex-col items-start">
            <div className="ml-[25px] flex w-[62%] items-start md:ml-0 md:w-full sm:flex-col">
              <Heading as="h1" className="mt-[9px] !font-extrabold capitalize">
                Order Id{" "}
              </Heading>
              <Input shape="round" name="edittext" className="ml-3.5 flex-grow sm:ml-0 sm:px-5" />
              <Button size="xs" shape="square" className="ml-6 min-w-[134px] font-extrabold sm:ml-0">
                Submit
              </Button>
            </div>
            <div className="mt-[72px] flex w-[95%] gap-5 self-center md:w-full md:flex-col">
              <div className="relative h-[351px] w-full md:h-auto">
                <div className="ml-[17px] mt-[9px] flex w-[79%] flex-col items-start gap-7 md:ml-0">
                  <Heading size="md" as="h2" className="self-end text-center capitalize">
                    Workstation 01
                  </Heading>
                  <Heading as="h3" className="w-[80%] !font-black capitalize leading-[121.02%] md:w-full">
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
                <Img
                  src="images/img_group_45.svg"
                  alt="image"
                  className="absolute bottom-0 left-0 right-0 top-0 m-auto h-[351px] w-full rounded-[31px]"
                />
              </div>
              <div className="relative h-[351px] w-full md:h-auto">
                <div className="mt-[13px] flex w-[77%]">
                  <div className="flex w-full flex-col items-start gap-4">
                    <Heading size="md" as="h4" className="text-center capitalize">
                      Workstation 02
                    </Heading>
                    <div className="relative ml-[13px] h-[220px] w-[85%] md:ml-0 md:h-auto">
                      <Text size="xs" as="p" className="mb-[65px] capitalize">
                        No of items :{" "}
                      </Text>
                      <Heading
                        as="h5"
                        className="absolute bottom-0 left-0 right-0 top-0 m-auto h-max w-full !font-black capitalize leading-[121.02%]"
                      >
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
                  </div>
                </div>
                <Img
                  src="images/img_group_45.svg"
                  alt="image"
                  className="absolute bottom-0 left-0 right-0 top-0 m-auto h-[351px] w-full rounded-[31px]"
                />
              </div>
            </div>
            <div className="mt-[47px] flex justify-between gap-5 self-stretch md:flex-col">
              <div className="flex w-[46%] flex-col items-center gap-[11px] md:w-full">
                <Heading size="md" as="h6" className="text-center capitalize">
                  Progress
                </Heading>
                <div className="h-[43px] self-stretch border-8 border-solid border-white-A700" />
              </div>
              <div className="flex w-[46%] flex-col items-center gap-[11px] md:w-full">
                <Heading size="md" as="h1" className="text-center capitalize">
                  Progress
                </Heading>
                <div className="h-[43px] self-stretch border-8 border-solid border-white-A700" />
              </div>
            </div>
            <Heading size="md" as="h1" className="mt-[27px] self-end text-center capitalize">
              Overall Progress
            </Heading>
          </div>
          <div className="absolute bottom-0 right-[0.00px] top-0 my-auto flex h-max w-[79%] items-center justify-center md:relative md:flex-col">
            <div className="mb-[37px] h-[43px] flex-1 self-end border-8 border-solid border-white-A700 md:self-stretch" />
            <div className="relative ml-[-128px] flex w-[38%] flex-col items-start gap-[63px] bg-black-900_7f p-[47px] md:ml-0 md:w-full md:p-5 sm:gap-[31px]">
              <div className="h-[231px] w-[61%] self-center rounded-[50%] bg-blue_gray-100" />
              <div className="mb-[85px] ml-1.5 flex flex-col items-start gap-[50px] md:ml-0">
                <Heading size="s" as="h2" className="text-center capitalize">
                  Name :
                </Heading>
                <Heading size="s" as="h3" className="text-center capitalize">
                  Contact No :
                </Heading>
                <Heading size="s" as="h4" className="text-center capitalize">
                  Department :
                </Heading>
                <Heading size="s" as="h5" className="ml-[9px] text-center capitalize md:ml-0">
                  Position :
                </Heading>
                <a href="https://www.youtube.com/embed/bv8Fxk0sz7I" target="_blank">
                  <Button shape="square" className="min-w-[241px] self-end font-black text-black-900_01 sm:px-5">
                    Sign Out
                  </Button>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
