push 0
push function8
push 12
push 1
push 2
push 10
push 1
push classtestClass
new
push 3
push classB
new
push 123
lfp
push -4
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
lfp
push -2
lfp
add
lw
js
lfp
push -7
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
push 12
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
lfp
push 8
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

function3:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

function4:
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
push 2
push 0
lfp
add
lw
calchoff
add
lw
add
push 1
push classtestClass
new
srv
sra
pop
sfp
lrv
lra
js

function5:
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
push 2
push 0
lfp
add
lw
calchoff
add
lw
mult
push 1
push classtestClass
new
srv
sra
pop
sfp
lrv
lra
js

function6:
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
push 2
push 0
lfp
add
lw
calchoff
add
lw
sub
push 1
push classtestClass
new
srv
sra
pop
sfp
lrv
lra
js

function7:
cfp
lra
lfp
push 8
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

function8:
cfp
lra
push 1
push 1
push classtestClass
new
push 1
push classA
new
srv
sra
pop
sfp
lrv
lra
js
classA:
function1
function2
function3
classB:
function4
function5
function6
function7
classtestClass:
function0
classnull:
