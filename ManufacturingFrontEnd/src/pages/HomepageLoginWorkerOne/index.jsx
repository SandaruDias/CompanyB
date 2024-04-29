import React from "react";
import { Helmet } from "react-helmet";
import { Button, Input, Text, Heading, Img } from "../../components";

export default function HomepageLoginWorkerOnePage() {
  return (
    <>
      <Helmet>
        <title>assemblyline</title>
        <meta name="description" content="Web site created using create-react-app" />
      </Helmet>
      <div className="flex h-[1024px] w-full flex-col items-center justify-center gap-[106px] bg-[url(/public/images/img_home_page_login.png)] bg-cover bg-no-repeat pb-[150px] md:h-auto md:gap-[79px] md:pb-5 sm:gap-[53px]">
        <header className="self-stretch bg-black-900_01 p-1.5">
          <div className="mb-2.5 flex items-center justify-between gap-5 md:flex-col">
            <div className="flex flex-wrap items-center gap-[25px]">
              <Text size="xl" as="p" className="text-center !font-bebasneue capitalize !text-white-A700">
                company B
              </Text>
              <Heading size="s" as="h2" className="mb-[13px] self-end text-center capitalize">
                Assembly Line
              </Heading>
            </div>
            <Img
              src="images/img_header_logo.png"
              alt="headerlogo"
              className="mb-[33px] h-[40px] w-[201px] object-cover"
            />
          </div>
        </header>
        <div className="container-xs px-[136px] md:p-5 md:px-5">
          <div className="relative h-[624px] md:h-auto">
            <Button shape="round" className="mb-[71px] min-w-[184px] font-black sm:px-5">
              Log in
            </Button>
            <div className="absolute bottom-0 left-0 right-0 top-0 m-auto flex h-max w-full flex-col items-center gap-[15px] rounded-[70px] bg-black-900_82 px-[61px] pb-[61px] md:px-5 md:pb-5">
              <Text size="lg" as="p" className="text-center !font-bebasneue capitalize !text-white-A700">
                Log in 
              </Text>
              <div className="flex w-[65%] justify-center rounded-[31px] bg-white-A700 md:w-full md:p-5">
                <div className="mb-[5px] flex w-full flex-col gap-[54px] sm:gap-[27px]">
                  <div className="ml-3.5 flex items-center justify-between gap-5 md:ml-0">
                    <Heading
                      size="s"
                      as="h1"
                      className="mb-[11px] self-end text-center !font-bold capitalize !text-black-900_01"
                    >
                      Admin Portal
                    </Heading>
                    <Button size="xl" className="min-w-[296px] rounded-tr-[31px] font-bold sm:px-5">
                      Worker Portal
                    </Button>
                  </div>
                  <div className="flex w-[94%] flex-col items-start gap-7 md:w-full">
                    <div className="flex w-[88%] items-start justify-between gap-5 md:w-full sm:flex-col">
                      <Text as="p" className="text-center capitalize">
                        Username
                      </Text>
                      <Input shape="round" name="edittext" className="w-[53%] sm:w-full sm:px-5" />
                    </div>
                    <div className="flex w-[88%] items-start justify-between gap-5 md:w-full sm:flex-col">
                      <div className="flex flex-col">
                        <Text as="p" className="text-center capitalize">
                          Password
                        </Text>
                        <Text as="p" className="relative mt-[-40px] text-center capitalize">
                          Password
                        </Text>
                      </div>
                      <Input shape="round" name="edittext_one" className="w-[53%] sm:w-full sm:px-5" />
                    </div>
                    <div className="flex items-start gap-[38px] self-stretch sm:flex-col">
                      <Text as="p" className="mt-[5px] text-center capitalize">
                        Workstation
                      </Text>
                      <Input
                        size="sm"
                        name="workstationCoun"
                        placeholder={`Workstation 01`}
                        className="flex-grow rounded-[28px] font-medium capitalize sm:px-5"
                      />
                    </div>
                    <a href="https://www.youtube.com/embed/bv8Fxk0sz7I" target="_blank">
                      <Button shape="round" className="min-w-[184px] self-center font-black sm:px-5">
                        Log in
                      </Button>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
