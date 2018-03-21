package com.sharebaseinc;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple13;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class DAO extends Contract {
    private static final String BINARY = "";

    protected DAO(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DAO(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<ProposalAddedEventResponse> getProposalAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ProposalAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ProposalAddedEventResponse> responses = new ArrayList<ProposalAddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalAddedEventResponse typedResponse = new ProposalAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.description = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ProposalAddedEventResponse> proposalAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ProposalAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ProposalAddedEventResponse>() {
            @Override
            public ProposalAddedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ProposalAddedEventResponse typedResponse = new ProposalAddedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.description = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<VotedEventResponse> getVotedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Voted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<VotedEventResponse> responses = new ArrayList<VotedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            VotedEventResponse typedResponse = new VotedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.voter = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.position = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<VotedEventResponse> votedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Voted", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, VotedEventResponse>() {
            @Override
            public VotedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                VotedEventResponse typedResponse = new VotedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.voter = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.position = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ProposalTalliedEventResponse> getProposalTalliedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ProposalTallied", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ProposalTalliedEventResponse> responses = new ArrayList<ProposalTalliedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProposalTalliedEventResponse typedResponse = new ProposalTalliedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.quorum = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ProposalTalliedEventResponse> proposalTalliedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ProposalTallied", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ProposalTalliedEventResponse>() {
            @Override
            public ProposalTalliedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ProposalTalliedEventResponse typedResponse = new ProposalTalliedEventResponse();
                typedResponse.log = log;
                typedResponse.proposalID = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.quorum = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public List<AllowedRecipientChangedEventResponse> getAllowedRecipientChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("AllowedRecipientChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<AllowedRecipientChangedEventResponse> responses = new ArrayList<AllowedRecipientChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AllowedRecipientChangedEventResponse typedResponse = new AllowedRecipientChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._recipient = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._allowed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AllowedRecipientChangedEventResponse> allowedRecipientChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("AllowedRecipientChanged", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, AllowedRecipientChangedEventResponse>() {
            @Override
            public AllowedRecipientChangedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                AllowedRecipientChangedEventResponse typedResponse = new AllowedRecipientChangedEventResponse();
                typedResponse.log = log;
                typedResponse._recipient = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._allowed = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<Tuple13<String, BigInteger, String, BigInteger, Boolean, Boolean, byte[], BigInteger, Boolean, Boolean, BigInteger, BigInteger, String>> proposals(BigInteger param0) {
        final Function function = new Function("proposals", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple13<String, BigInteger, String, BigInteger, Boolean, Boolean, byte[], BigInteger, Boolean, Boolean, BigInteger, BigInteger, String>>(
                new Callable<Tuple13<String, BigInteger, String, BigInteger, Boolean, Boolean, byte[], BigInteger, Boolean, Boolean, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple13<String, BigInteger, String, BigInteger, Boolean, Boolean, byte[], BigInteger, Boolean, Boolean, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple13<String, BigInteger, String, BigInteger, Boolean, Boolean, byte[], BigInteger, Boolean, Boolean, BigInteger, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (Boolean) results.get(4).getValue(), 
                                (Boolean) results.get(5).getValue(), 
                                (byte[]) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (Boolean) results.get(8).getValue(), 
                                (Boolean) results.get(9).getValue(), 
                                (BigInteger) results.get(10).getValue(), 
                                (BigInteger) results.get(11).getValue(), 
                                (String) results.get(12).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> votingRegister(String param0, BigInteger param1) {
        final Function function = new Function("votingRegister", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> executeProposal(BigInteger _proposalID, byte[] _transactionData) {
        final Function function = new Function(
                "executeProposal", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalID), 
                new org.web3j.abi.datatypes.DynamicBytes(_transactionData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unblockMe() {
        final Function function = new Function(
                "unblockMe", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> actualBalance() {
        final Function function = new Function("actualBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unVoteAll() {
        final Function function = new Function(
                "unVoteAll", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> allowedRecipients(String param0) {
        final Function function = new Function("allowedRecipients", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> newProposal(String _recipient, BigInteger _amount, String _description, byte[] _transactionData, BigInteger _debatingPeriod, Boolean _newCurator, BigInteger weiValue) {
        final Function function = new Function(
                "newProposal", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.DynamicBytes(_transactionData), 
                new org.web3j.abi.datatypes.generated.Uint256(_debatingPeriod), 
                new org.web3j.abi.datatypes.Bool(_newCurator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> minQuorumDivisor() {
        final Function function = new Function("minQuorumDivisor", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> newContract(String _newContract) {
        final Function function = new Function(
                "newContract", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newContract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeAllowedRecipients(String _recipient, Boolean _allowed) {
        final Function function = new Function(
                "changeAllowedRecipients", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_recipient), 
                new org.web3j.abi.datatypes.Bool(_allowed)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> halveMinQuorum() {
        final Function function = new Function(
                "halveMinQuorum", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> proposalDeposit() {
        final Function function = new Function("proposalDeposit", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> numberOfProposals() {
        final Function function = new Function("numberOfProposals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> lastTimeMinQuorumMet() {
        final Function function = new Function("lastTimeMinQuorumMet", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unVote(BigInteger _proposalID) {
        final Function function = new Function(
                "unVote", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> verifyPreSupport(BigInteger _proposalID) {
        final Function function = new Function(
                "verifyPreSupport", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> newProposal(String _recipient, BigInteger _amount, String _description, byte[] _transactionData, BigInteger _debatingPeriod, BigInteger weiValue) {
        final Function function = new Function(
                "newProposal", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.DynamicBytes(_transactionData), 
                new org.web3j.abi.datatypes.generated.Uint64(_debatingPeriod)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger _proposalID, Boolean _supportsProposal) {
        final Function function = new Function(
                "vote", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalID), 
                new org.web3j.abi.datatypes.Bool(_supportsProposal)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> changeProposalDeposit(BigInteger _proposalDeposit) {
        final Function function = new Function(
                "changeProposalDeposit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalDeposit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> blocked(String param0) {
        final Function function = new Function("blocked", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> curator() {
        final Function function = new Function("curator", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> checkProposalCode(BigInteger _proposalID, String _recipient, BigInteger _amount, byte[] _transactionData) {
        final Function function = new Function("checkProposalCode", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_proposalID), 
                new org.web3j.abi.datatypes.Address(_recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.DynamicBytes(_transactionData)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<DAO> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _curator, BigInteger _proposalDeposit, String _token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_curator), 
                new org.web3j.abi.datatypes.generated.Uint256(_proposalDeposit), 
                new org.web3j.abi.datatypes.Address(_token)));
        return deployRemoteCall(DAO.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<DAO> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _curator, BigInteger _proposalDeposit, String _token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_curator), 
                new org.web3j.abi.datatypes.generated.Uint256(_proposalDeposit), 
                new org.web3j.abi.datatypes.Address(_token)));
        return deployRemoteCall(DAO.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static DAO load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DAO(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DAO load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DAO(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class ProposalAddedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public String recipient;

        public BigInteger amount;

        public String description;
    }

    public static class VotedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public String voter;

        public Boolean position;
    }

    public static class ProposalTalliedEventResponse {
        public Log log;

        public BigInteger proposalID;

        public Boolean result;

        public BigInteger quorum;
    }

    public static class AllowedRecipientChangedEventResponse {
        public Log log;

        public String _recipient;

        public Boolean _allowed;
    }
}
