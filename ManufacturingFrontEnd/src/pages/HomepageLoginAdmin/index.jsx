import React from "react";
import { Helmet } from "react-helmet";
import { Button, Input, Text, Heading, Img } from "../../components";

export default function HomepageLoginAdminPage() {
  return (
    <>
      <Helmet>
        <title>assemblyline</title>
        <meta name="description" content="Web site created using create-react-app" />
      </Helmet>
      <div className="flex h-[1024px] w-full flex-col items-center justify-center gap-[102px] bg-[url(/public/images/img_home_page_login.png)] bg-cover bg-no-repeat pb-[154px] md:h-auto md:gap-[76px] md:pb-5 sm:gap-[51px]">
        <header className="flex items-end justify-center self-stretch bg-black-900_7f_01">
          <div className="mt-3.5 flex w-[95%] items-start justify-between gap-5 md:w-full md:flex-col md:p-5">
            <div className="flex flex-wrap items-center gap-[22px]">
              <Text size="xl" as="p" className="text-center !font-bebasneue capitalize !text-white-A700">
                company B
              </Text>
              <Heading size="s" as="h2" className="mb-[23px] self-end text-center capitalize">
                Assembly Line
              </Heading>
            </div>
            <Img
              src="images/img_header_logo.png"
              alt="headerlogo"
              className="mt-[25px] h-[40px] w-[201px] object-cover"
            />
          </div>
        </header>
        <div className="container-xs flex flex-col items-center px-[127px] md:p-5 md:px-5">
          <div className="flex w-[97%] flex-col items-center gap-8 rounded-[70px] bg-black-900_82 p-3.5 md:w-full">
            <Text size="lg" as="p" className="text-center !font-bebasneue capitalize !text-white-A700">
              Log in Portal
            </Text>
            <div className="mb-6 flex w-[59%] justify-center rounded-[31px] bg-white-A700 md:w-full md:p-5">
              <div className="mb-[62px] flex w-[94%] flex-col items-center gap-[45px] md:w-full">
                <div className="flex flex-wrap items-center justify-between gap-5 self-stretch">
                  <Heading
                    size="s"
                    as="h1"
                    className="flex items-center justify-center rounded-tl-[31px] bg-blue_gray-100 pb-2.5 pl-[35px] pr-[21px] pt-[22px] text-center !font-bold capitalize !text-black-900_01 sm:px-5 sm:pt-5"
                  >
                    Admin Portal
                  </Heading>
                  <Heading
                    size="s"
                    as="h2"
                    className="mb-[9px] self-end text-center !font-bold capitalize !text-black-900_01"
                  >
                    Worker Portal
                  </Heading>
                </div>
                <div className="flex w-[86%] justify-center md:w-full">
                  <div className="flex w-full flex-col items-end gap-[51px] sm:gap-[25px]">
                    <div className="flex items-center justify-between gap-5 self-stretch sm:flex-col">
                      <Text as="p" className="mb-[5px] self-end text-center capitalize">
                        Username
                      </Text>
                      <Input shape="round" name="edittext" className="w-[54%] sm:w-full sm:px-5" />
                    </div>
                    <div className="flex items-center justify-between gap-5 self-stretch sm:flex-col">
                      <Text as="p" className="self-end text-center capitalize">
                        Password
                      </Text>
                      <Input shape="round" name="edittext_one" className="w-[53%] sm:w-full sm:px-5" />
                    </div>
                    <a href="https://www.youtube.com/embed/bv8Fxk0sz7I" target="_blank">
                      <Button shape="round" className="mr-[126px] min-w-[184px] font-black md:mr-0 sm:px-5">
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
