import React from "react";
import { Helmet } from "react-helmet";
import { Heading, Text, Input } from "../../components";
import Header from "../../components/Header";

export default function AdminInterfacePage() {
  return (
    <>
      <Helmet>
        <title>assemblyline</title>
        <meta name="description" content="Web site created using create-react-app" />
      </Helmet>
      <div className="flex h-[1024px] w-full flex-col items-center gap-[71px] bg-[url(/public/images/img_home_page_login.png)] bg-cover bg-no-repeat pb-7 md:h-auto md:gap-[53px] sm:gap-[35px] sm:pb-5">
        <Header className="flex items-center justify-between gap-5 self-stretch bg-black-900_7f_01 p-2.5 md:flex-col" />
        <div className="flex w-[94%] md:w-full md:p-5">
          <div className="flex w-full flex-col">
            <div className="container-xs flex flex-col items-start px-[9px] md:p-5">
              <div className="flex w-[91%] items-end md:w-full md:flex-col">
                <Heading as="h1" className="mb-3 !font-extrabold capitalize">
                  Order Id{" "}
                </Heading>
                <Input shape="round" name="edittext" className="ml-3.5 w-[22%] md:ml-0 md:w-full sm:px-5" />
                <div className="relative ml-[21px] h-[80px] flex-1 md:ml-0 md:w-full md:flex-none md:self-stretch">
                  <div className="absolute bottom-[10.68px] right-[11.63px] m-auto flex w-[55%] items-center justify-end sm:relative sm:flex-col">
                    <div className="flex w-full items-center justify-end sm:w-full">
                      <div className="h-[26px] w-[26px] rounded-[13px] border-[3px] border-solid border-white-A700 bg-white-A700" />
                      <div className="relative ml-[-2px] h-[8px] flex-1 border-[3px] border-solid border-white-A700 bg-white-A700" />
                    </div>
                    <div className="relative ml-[-3px] flex w-full justify-between gap-5 sm:ml-0 sm:w-full">
                      <div className="h-[26px] w-[26px] self-end rounded-[13px] border-[3px] border-solid border-white-A700 bg-white-A700" />
                      <div className="h-[26px] w-[26px] self-start rounded-[13px] border-[3px] border-solid border-white-A700" />
                    </div>
                  </div>
                  <Heading as="h2" className="absolute left-[41%] top-[1.87px] m-auto capitalize">
                    Start
                  </Heading>
                  <div className="absolute bottom-0 left-0 right-0 top-0 m-auto flex h-max w-full flex-col items-end">
                    <Heading as="h3" className="mr-[173px] text-center capitalize md:mr-0">
                      Process
                    </Heading>
                    <Input
                      name="submit"
                      placeholder={`End`}
                      className="relative mt-[-25px] h-[73px] self-stretch pl-5 pr-[35px] text-[26px] font-extrabold capitalize text-black-900_01 sm:pr-5"
                    >
                      Submit
                    </Input>
                  </div>
                  <div className="absolute bottom-[20.68px] right-[5%] m-auto h-[8px] w-[23%] border-[3px] border-solid border-white-A700" />
                </div>
              </div>
            </div>
            <div className="mt-[57px] grid grid-cols-3 justify-center gap-16 md:grid-cols-2 sm:grid-cols-1">
              <div className="flex h-[351px] w-full items-center justify-center rounded-[31px] bg-[url(/public/images/img_group_45.svg)] bg-cover bg-no-repeat p-[25px] md:h-auto sm:p-5">
                <div className="flex w-[90%] flex-col items-start gap-7 md:w-full">
                  <Heading size="md" as="h4" className="self-end text-center capitalize">
                    Workstation 01
                  </Heading>
                  <Heading as="h5" className="w-[80%] !font-black capitalize leading-[121.02%] md:w-full">
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
              <div className="flex h-[351px] w-full items-start justify-center rounded-[31px] bg-[url(/public/images/img_group_45.svg)] bg-cover bg-no-repeat p-[15px] md:h-auto">
                <div className="mb-5 flex w-[88%] justify-center md:w-full">
                  <div className="flex w-full flex-col items-start gap-[30px]">
                    <Heading size="md" as="h6" className="self-end text-center capitalize">
                      Workstation 02
                    </Heading>
                    <div className="relative h-[220px] w-[78%] md:h-auto">
                      <Text size="xs" as="p" className="mb-[65px] capitalize">
                        No of items :{" "}
                      </Text>
                      <Heading
                        as="h4"
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
              </div>
              <div className="flex h-[351px] w-full items-start rounded-[31px] bg-[url(/public/images/img_group_45.svg)] bg-cover bg-no-repeat p-3.5 md:h-auto">
                <div className="mb-[19px] flex w-[83%] flex-col items-start gap-[31px] md:w-full">
                  <Heading size="md" as="h1" className="text-center capitalize">
                    Workstation 03
                  </Heading>
                  <Heading as="h4" className="w-[81%] !font-black capitalize leading-[121.02%] md:w-full">
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
              <div className="flex w-full flex-col items-center gap-[11px]">
                <Heading size="md" as="h1" className="text-center capitalize">
                  Progress
                </Heading>
                <div className="h-[43px] self-stretch border-8 border-solid border-white-A700" />
              </div>
              <div className="flex w-full flex-col items-center gap-[11px]">
                <Heading size="md" as="h1" className="text-center capitalize">
                  Progress
                </Heading>
                <div className="h-[43px] self-stretch border-8 border-solid border-white-A700" />
              </div>
              <div className="flex w-full flex-col items-center gap-[11px]">
                <Heading size="md" as="h1" className="text-center capitalize">
                  Progress
                </Heading>
                <div className="h-[43px] self-stretch border-8 border-solid border-white-A700" />
              </div>
            </div>
            <div className="container-xs mt-[27px] flex flex-col items-end pl-14 pr-[273px] md:p-5 md:px-5">
              <Heading size="md" as="h1" className="mr-[189px] text-center capitalize md:mr-0">
                Overall Progress
              </Heading>
              <div className="mr-4 h-[43px] w-[78%] border-8 border-solid border-white-A700 md:mr-0" />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
