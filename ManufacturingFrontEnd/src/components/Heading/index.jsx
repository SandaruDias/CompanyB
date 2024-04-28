import React from "react";

const sizes = {
  s: "text-[33px] font-black md:text-[31px] sm:text-[29px]",
  md: "text-[40px] font-extrabold md:text-[38px] sm:text-4xl",
  xs: "text-[26px] font-bold md:text-2xl sm:text-[22px]",
};

const Heading = ({ children, className = "", size = "xs", as, ...restProps }) => {
  const Component = as || "h6";

  return (
    <Component className={`text-white-A700 font-inter ${className} ${sizes[size]}`} {...restProps}>
      {children}
    </Component>
  );
};

export { Heading };
