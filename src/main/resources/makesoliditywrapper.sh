git clone https://github.com/slockit/DAO.git 
solc DAO.sol --bin --abi --optimize -o output

web3j solidity generate output/DAO.bin output/DAO.abi -o src/main/java -p com.sharebaseinc
