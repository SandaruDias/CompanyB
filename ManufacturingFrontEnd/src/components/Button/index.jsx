import React from "react";
import PropTypes from "prop-types";

const shapes = {
  round: "rounded-[26px]",
  square: "rounded-[0px]",
};
const variants = {
  fill: {
    blue_gray_100: "bg-blue_gray-100 text-black-900_01",
    white_A700: "bg-white-A700 text-black-900_01",
    black_900_01: "bg-black-900_01 text-white-A700",
  },
  outline: {
    white_A700: "border-white-A700 border-[6px] border-solid text-white-A700",
  },
};
const sizes = {
  xl: "h-[75px] px-[35px] text-[33px]",
  "3xl": "h-[97px] px-[33px] text-[26px]",
  xs: "h-[49px] px-5 text-[26px]",
  sm: "h-[52px] px-7 text-[33px]",
};

const Button = ({
  children,
  className = "",
  leftIcon,
  rightIcon,
  shape,
  variant = "fill",
  size = "sm",
  color = "",
  ...restProps
}) => {
  return (
    <button
      className={`${className} flex flex-row items-center justify-center text-center cursor-pointer capitalize ${(shape && shapes[shape]) || ""} ${(size && sizes[size]) || ""} ${(variant && variants[variant]?.[color]) || ""}`}
      {...restProps}
    >
      {!!leftIcon && leftIcon}
      {children}
      {!!rightIcon && rightIcon}
    </button>
  );
};

Button.propTypes = {
  className: PropTypes.string,
  children: PropTypes.node,
  leftIcon: PropTypes.node,
  rightIcon: PropTypes.node,
  shape: PropTypes.oneOf(["round", "square"]),
  size: PropTypes.oneOf(["xl", "3xl", "xs", "sm"]),
  variant: PropTypes.oneOf(["fill", "outline"]),
  color: PropTypes.oneOf(["blue_gray_100", "white_A700", "black_900_01"]),
};

export { Button };
