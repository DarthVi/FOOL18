push 0
push 42
push 2
push 3
push 11
push 6
push 7
push 19
push 7
push classfinalClass
new
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
print
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
lfp
push 0
lfp
add
lw
copy
lw
push 0
add
lc
js
srv
sra
pop
sfp
lrv
lra
js
classfinalClass:
function0
function1
classtestClass:
function0
classnull:
