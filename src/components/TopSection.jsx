import React from "react";
import styled from "styled-components";

function TopSection() {
  return (
    <TopSectionContainer>
      <OrderArea>손님 주문 공간</OrderArea>
    </TopSectionContainer>
  );
}

export default TopSection;

const TopSectionContainer = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f0f8ff;
`;

const OrderArea = styled.div`
  width: 80%;
  height: 80%;
  background: #ffffff;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 2px solid #000;
  border-radius: 10px;
  font-size: 24px;
  font-weight: bold;
`;
