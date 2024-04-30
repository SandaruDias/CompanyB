import React from "react";

const sizes = {
  xs: "text-[26px] font-normal md:text-2xl sm:text-[22px]",
  lg: "text-6xl font-normal md:text-[52px] sm:text-[46px]",
  xl: "text-[100px] font-normal md:text-5xl",
  md: "text-[33px] font-normal md:text-[31px] sm:text-[29px]",
};

const Text = ({ children, className = "", as, size = "md", ...restProps }) => {
  const Component = as || "p";

  return (
    <Component className={`text-black-900_01 font-inter ${className} ${sizes[size]}`} {...restProps}>
      {children}
    </Component>
  );
};

export { Text };
