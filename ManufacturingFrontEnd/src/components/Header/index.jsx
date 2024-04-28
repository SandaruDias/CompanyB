import React from "react";
import { Heading, Text } from "./..";

export default function Header({ ...props }) {
  return (
    <header {...props}>
      <div className="ml-[57px] flex flex-wrap items-center gap-[33px] md:ml-0">
        <Text size="xl" as="p" className="text-center !font-bebasneue capitalize !text-white-A700">
          company B
        </Text>
        <Heading size="s" as="h2" className="mb-[21px] self-end text-center capitalize">
          Assembly Line
        </Heading>
      </div>
      <ul className="!mb-[33px] !mr-[27px] flex flex-wrap gap-9 md:mr-0">
        <li>
          <a href="#">
            <Heading size="s" as="h2" className="text-center !font-extrabold capitalize tracking-[1.98px]">
              Home Page
            </Heading>
          </a>
        </li>
        <li>
          <a href="#">
            <Heading size="s" as="h2" className="text-center !font-extrabold capitalize">
              Worker Details
            </Heading>
          </a>
        </li>
      </ul>
    </header>
  );
}
